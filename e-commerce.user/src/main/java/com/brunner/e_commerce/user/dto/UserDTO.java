package com.brunner.e_commerce.user.dto;

import com.brunner.e_commerce.user.domain.Address;
import com.brunner.e_commerce.user.domain.UserType;

public record UserDTO(
        String id,
        String cpf,
        String password,
        String email,
        String firstName,
        String lastName,
        UserType userType
) {
}
