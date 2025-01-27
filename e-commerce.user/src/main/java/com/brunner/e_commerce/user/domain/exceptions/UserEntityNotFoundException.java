package com.brunner.e_commerce.user.domain.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class UserEntityNotFoundException extends EntityNotFoundException {
    public UserEntityNotFoundException() {
        super("Entity not found on database");
    }

    public UserEntityNotFoundException(String message) {
        super(message);
    }
}
