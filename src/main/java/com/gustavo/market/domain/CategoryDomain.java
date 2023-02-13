package com.gustavo.market.domain;

import lombok.Data;

@Data
public class CategoryDomain {
    private long categoryId;
    private String category;
    private boolean active;
}
