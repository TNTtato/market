package com.gustavo.market.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @Column(name = "id_client")
    private String idClient;

    private String name;
    private String lastname;
    private Integer cellphone;
    private String address;
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Buy> buys;
}
