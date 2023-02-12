package com.gustavo.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyProductPK implements Serializable {

    @Column(name = "id_buy")
    private Long idBuy;
    @Column(name = "id_product")
    private Long idProduct;

}
