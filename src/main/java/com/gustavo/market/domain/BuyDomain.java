package com.gustavo.market.domain;

import java.time.LocalDateTime;
import java.util.List;

public class BuyDomain {
    private long buyId;
    private String clientId;
    private LocalDateTime buyDate;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<BuyItem> items;

    public long getBuyId() {
        return buyId;
    }

    public void setBuyId(long buyId) {
        this.buyId = buyId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
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

    public List<BuyItem> getItems() {
        return items;
    }

    public void setItems(List<BuyItem> items) {
        this.items = items;
    }
}
