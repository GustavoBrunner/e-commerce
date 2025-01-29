package com.brunner.e_commerce.user.dto;

import lombok.Builder;

@Builder
public record AddressViewDto(
        String city,
        String country,
        String state,
        String street,
        String complement,
        boolean isMain,
        String userName
) {
}
