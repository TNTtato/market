package com.gustavo.market.persistence.crud;

import com.gustavo.market.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends JpaRepository<Product, Long> {

    //@Query("select P from Product P where P.idCategory = ? order by P.name ASC")
    List<Product> findByIdCategoryOrderByNameAsc(Long idCategory);

    //@Query("select P from Product P where P.inStock <= ?1 and P.state = ?2")
    Optional<List<Product>> findByInStockLessThanAndState(int inStock, boolean state);
}
