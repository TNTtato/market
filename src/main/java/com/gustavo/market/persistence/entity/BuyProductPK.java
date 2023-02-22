package com.gustavo.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class BuyProductPK implements Serializable{

    @Column(name = "id_buy")
    private Long idBuy;
    @Column(name = "id_product")
    private Long idProduct;

    public Long getIdBuy() {
        return idBuy;
    }

    public void setIdBuy(Long idBuy) {
        this.idBuy = idBuy;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyProductPK that = (BuyProductPK) o;
        return Objects.equals(idBuy, that.idBuy) && Objects.equals(idProduct, that.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBuy, idProduct);
    }
}
