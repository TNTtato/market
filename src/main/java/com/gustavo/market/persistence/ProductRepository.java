package com.gustavo.market.persistence;

import com.gustavo.market.domain.ProductDomain;
import com.gustavo.market.domain.repository.ProductDomainRepository;
import com.gustavo.market.persistence.crud.ProductCrudRepository;
import com.gustavo.market.persistence.entity.Product;
import com.gustavo.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductDomainRepository {

    private ProductCrudRepository productCrudRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductRepository(ProductCrudRepository productCrudRepository, ProductMapper productMapper) {
        this.productCrudRepository = productCrudRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDomain> getAll() {

        List<Product> products = productCrudRepository.findAll();
        return productMapper.toProductsDomain(products);
    }

    @Override
    public List<ProductDomain> getByCategoryId(long idCategory) {
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return productMapper.toProductsDomain(products);
    }

    @Override
    public Optional<List<ProductDomain>> getScarce(int inStock) {
        Optional<List<Product>> products = productCrudRepository.findByInStockLessThanAndState(inStock, true);
        return products.map( prod -> productMapper.toProductsDomain((prod)));
    }

    @Override
    public Optional<ProductDomain> getProduct(long idProduct) {
        return productCrudRepository.findById(idProduct).map(product -> productMapper.toProductDomain(product));
    }

    @Override
    public ProductDomain save(ProductDomain productDomain) {
        Product product = productMapper.toProduct(productDomain);
        return productMapper.toProductDomain(productCrudRepository.save(product));
    }

    @Override
    public void delete(long idProduct) {
        productCrudRepository.deleteById(idProduct);
    }

}
