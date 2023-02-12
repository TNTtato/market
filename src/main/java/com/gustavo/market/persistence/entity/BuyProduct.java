package com.gustavo.market.persistence.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buys_products")
public class BuyProduct {

    @EmbeddedId
    private BuyProductPK id;

    private Integer quantity;
    private Double total;
    private Boolean state;
}
