package com.gustavo.market.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "buys")
@AllArgsConstructor
@NoArgsConstructor
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_buy")
    private Long idBuy;

    @Column(name = "id_client")
    private String idClient;

    @Column(name = "buy_date")
    private LocalDateTime buyDate;

    @Column(name = "payment_method")
    private String paymentMethod;

    private String comment;
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_client", insertable = false, updatable = false)
    private Client client;
/*
    @OneToMany(mappedBy = "product")
    private List<BuyProduct> buysProducts;
 */
    public Long getIdBuy() {
        return idBuy;
    }

    public void setIdBuy(Long idBuy) {
        this.idBuy = idBuy;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public LocalDateTime getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(LocalDateTime buyDate) {
        this.buyDate = buyDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
/*
    public List<BuyProduct> getBuysProducts() {
        return buysProducts;
    }

    public void setBuysProducts(List<BuyProduct> buyProducts) {
        this.buysProducts = buyProducts;
    }

 */
}
