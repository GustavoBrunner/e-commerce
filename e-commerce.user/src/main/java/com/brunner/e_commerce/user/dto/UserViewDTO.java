package com.brunner.e_commerce.user.dto;

import com.brunner.e_commerce.user.domain.Address;
import com.brunner.e_commerce.user.domain.User;
import com.brunner.e_commerce.user.domain.UserType;

public record UserViewDTO(
        String email,
        String cpf,
        String firstName,
        String lastName,
        UserType userType) {
}
