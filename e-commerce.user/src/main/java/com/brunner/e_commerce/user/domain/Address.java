package com.brunner.e_commerce.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "address")
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String city;

    private String country;

    private String state;

    private String street;

    private String complement;

    @JoinColumn(name = "is_main")
    private boolean isMain;

    @ManyToOne
    @JoinColumn(name = "FK_user_id")
    private User user;
}
