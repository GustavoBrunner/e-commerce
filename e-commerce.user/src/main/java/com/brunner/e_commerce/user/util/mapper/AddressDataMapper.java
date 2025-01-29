package com.brunner.e_commerce.user.util.mapper;

import com.brunner.e_commerce.user.domain.Address;
import com.brunner.e_commerce.user.dto.AddressDto;
import com.brunner.e_commerce.user.dto.AddressViewDto;

import java.util.ArrayList;
import java.util.List;

public class AddressDataMapper {
    public static AddressViewDto mapEntityToViewDto(Address address) {
        return AddressViewDto.builder()
                .city(address.getCity())
                .state(address.getState())
                .complement(address.getComplement())
                .country(address.getCountry())
                .isMain(address.isMain())
                .userName(address.getUser().getFirstName() + " " + address.getUser().getLastName())
                .build();
    }

    public static Address mapDtoToEntity(AddressDto entity) {
        return new Address(entity);
    }

    public static List<AddressViewDto> mapListEntityToViewDto(List<Address> addresses) {
        List<AddressViewDto> viewDtos = new ArrayList<>();
        for(Address address: addresses){
            viewDtos.add(mapEntityToViewDto(address));
        }
        return viewDtos;
    }
}
