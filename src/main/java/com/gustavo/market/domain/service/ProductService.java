package com.gustavo.market.domain.service;

import com.gustavo.market.domain.ProductDomain;
import com.gustavo.market.domain.repository.ProductDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductDomainRepository productDomainRepository;

    @Autowired
    public ProductService(ProductDomainRepository productDomainRepository) {
        this.productDomainRepository = productDomainRepository;
    }

    public List<ProductDomain> getAll() {
        return productDomainRepository.getAll();
    }

    public Optional<ProductDomain> getProduct(long productId) {
        return productDomainRepository.getProduct(productId);
    }

    public List<ProductDomain> getByCategoryId(long categoryId) {
        return productDomainRepository.getByCategoryId(categoryId);
    }

    public Optional<List<ProductDomain>> getScarce(int quantity) {
        return productDomainRepository.getScarce(quantity);
    }

    public ProductDomain save(ProductDomain productDomain) {
        return productDomainRepository.save(productDomain);
    }

    public boolean delete(long productId) {
        return getProduct(productId).map(product -> {
            productDomainRepository.delete(productId);
            return true;
        }).orElse(false);
    }


}
