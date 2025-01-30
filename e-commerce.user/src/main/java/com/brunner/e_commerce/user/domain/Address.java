package com.brunner.e_commerce.user.domain;

import com.brunner.e_commerce.user.dto.AddressDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "address")
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    public Address(AddressDto dto){
        this.isMain = dto.isMain();
        this.city = dto.city();
        this.id = dto.id();
        this.complement = dto.complement();
        this.country = dto.country();
        this.street = dto.street();
        this.user = dto.user();
        this.state = dto.state();
    }
    @Id
    @GeneratedValue()
    @UuidGenerator
    @Column(name = "PK_id")
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
