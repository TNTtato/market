package com.gustavo.market.persistence.entity;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "id_buy", insertable = false, updatable = false)
    private Buy buy;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;
}
