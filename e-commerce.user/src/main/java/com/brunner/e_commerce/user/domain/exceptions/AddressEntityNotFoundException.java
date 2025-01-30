package com.brunner.e_commerce.user.domain.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AddressEntityNotFoundException extends Exception {

    public AddressEntityNotFoundException(){
        super("Entidade não encontrada no banco de dados");
    }
    public AddressEntityNotFoundException(String message){
        super(message);
    }
}
