package com.brunner.e_commerce.user.domain;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "users")
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue()
    @UuidGenerator
    @Column(name = "PK_id")
    private String id;

    private String cpf;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String token;

    private LocalDateTime tokenCreatedAt;

    @JoinColumn(name = "user_type")
    private UserType userType;

    @OneToOne()
    @JoinColumn(name = "fk_wallet_id")
    private Wallet wallet;

    @OneToOne
    @JoinColumn(name = "fk_main_address_id")
    private Address mainAddress;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

}
