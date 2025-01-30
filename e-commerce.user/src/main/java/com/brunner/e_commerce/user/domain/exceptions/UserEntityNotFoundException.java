package com.brunner.e_commerce.user.domain.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class UserEntityNotFoundException extends Exception {
    public UserEntityNotFoundException() {
        super("Entity not found on database");
    }

    public UserEntityNotFoundException(String message) {
        super(message);
    }
}
