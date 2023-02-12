package com.gustavo.market.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    private String name;
    private String barcode;
    private Boolean state;

    @Column(name = "id_category")
    private Long idCategory;

    @Column(name = "sell_price")
    private Double sellPrice;

    @Column(name = "in_stock")
    private Integer inStock;

}