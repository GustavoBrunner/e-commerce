package com.brunner.e_commerce.user.domain.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class AddressEntityNotFoundException extends EntityNotFoundException {
    public AddressEntityNotFoundException(){
        super("Entidade não encontrada no banco de dados");
    }
    public AddressEntityNotFoundException(String message){
        super(message);
    }
}
