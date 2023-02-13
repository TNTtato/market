package com.gustavo.market.persistence;

import com.gustavo.market.persistence.crud.ProductCrudRepository;
import com.gustavo.market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return productCrudRepository.findAll();
    }
    public List<Product> getByCategoryId(long idCategory) {
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Product>> getScarce(int inStock) {
        return productCrudRepository.findByInStockLessThanAndState(inStock, true);
    }

    public Optional<Product> getProduct(long idProduct) {
        return productCrudRepository.findById(idProduct);
    }

    public Product save(Product product) {
        return productCrudRepository.save(product);
    }

    public void delete(long idProduct) {
        productCrudRepository.deleteById(idProduct);
    }

}
