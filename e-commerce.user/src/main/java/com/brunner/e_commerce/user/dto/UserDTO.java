package com.brunner.e_commerce.user.dto;

import com.brunner.e_commerce.user.domain.Address;
import com.brunner.e_commerce.user.domain.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UserDTO(
        String id,
        @NotBlank String cpf,
        @NotBlank String password,
        @NotBlank @Email String email,
        @NotBlank String firstName,
        @NotBlank String lastName,
        Address mainAddress,
        UserType userType
) {
}
