package com.gustavo.market.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "buys")
@Data
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
}
