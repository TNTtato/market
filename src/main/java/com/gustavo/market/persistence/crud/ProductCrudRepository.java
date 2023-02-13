package com.gustavo.market.persistence.crud;

import com.gustavo.market.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends JpaRepository<Product, Long> {
    List<Product> findByIdCategoryOrderByNameAsc(Long idCategory);
    Optional<List<Product>> findByInStockLessThanAndState(int inStock, boolean state);
}
