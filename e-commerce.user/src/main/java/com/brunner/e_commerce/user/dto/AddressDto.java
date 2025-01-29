package com.brunner.e_commerce.user.dto;

import com.brunner.e_commerce.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record AddressDto(
        String id,
        @NotBlank String city,
        @NotBlank String county,
        @NotBlank String state,
        @NotBlank String street,
        @NotBlank String complement,
        @NotBlank boolean isMain,
        @NotBlank User user
) {
}
