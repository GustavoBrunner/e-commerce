package com.brunner.e_commerce.user.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    private User owner;

    private BigDecimal balance;

    private BigDecimal maxValue;

    

}
