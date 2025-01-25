package com.brunner.e_commerce.user.domain;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String cpf;

    private String email;

    private String firstName;

    private String lastName;

    @OneToOne()
    @JoinColumn(name = "fk_wallet_id")
    private Wallet wallet;

    @OneToOne
    @JoinColumn(name = "fk_main_address_id")
    private Address mainAddress;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

}
