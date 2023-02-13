package com.gustavo.market.domain;

import com.gustavo.market.persistence.entity.Category;
import lombok.Data;

@Data
public class ProductDomain {
    private long productId;
    private String name;
    private long categoryId;
    private double price;
    private int stock;
    private boolean active;
    private Category category;


}
