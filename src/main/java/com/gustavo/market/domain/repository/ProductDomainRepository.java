package com.gustavo.market.domain.repository;

import com.gustavo.market.domain.ProductDomain;

import java.util.List;
import java.util.Optional;

public interface ProductDomainRepository {
    List<ProductDomain> getAll();
    List<ProductDomain> getByCategoryId(long categoryId);
    Optional<List<ProductDomain>> getScarce(int quantity);
    Optional<ProductDomain> getProduct(long productId);
    ProductDomain save(ProductDomain productDomain);
    void delete(long productId);
}
