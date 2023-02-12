package com.gustavo.market.persistence.crud;

import com.gustavo.market.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCrudRepository extends JpaRepository<Product, Long> {
}
