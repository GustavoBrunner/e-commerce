package com.brunner.e_commerce.user.services.contracts;

import com.brunner.e_commerce.user.domain.Address;
import com.brunner.e_commerce.user.dto.AddressDto;
import com.brunner.e_commerce.user.dto.AddressViewDto;

import java.util.List;

public interface AddressService extends GenericService<AddressDto, AddressViewDto> {
    public List<AddressViewDto> findAllByUserId(String id);
}
