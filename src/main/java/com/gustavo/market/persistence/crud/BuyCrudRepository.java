package com.gustavo.market.persistence.crud;

import com.gustavo.market.persistence.entity.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuyCrudRepository extends JpaRepository<Buy, Long> {
    Optional<List<Buy>> findByIdClient(String idClient);
}
