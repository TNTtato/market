package com.gustavo.market.persistence;

import com.gustavo.market.persistence.crud.ProductCrudRepository;
import com.gustavo.market.persistence.entity.Product;

import java.util.List;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return productCrudRepository.findAll();
    }
}
