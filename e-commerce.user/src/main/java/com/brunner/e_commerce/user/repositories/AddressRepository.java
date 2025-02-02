package com.brunner.e_commerce.user.repositories;

import com.brunner.e_commerce.user.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {
    List<Address> getAllAddressByUserId(String userId);
    List<Address> getAllAddressByCity(String cityName);
    List<Address> getAllAddressByState(String stateName);
    List<Address> getAllAddressByCountry(String countryName);

}
