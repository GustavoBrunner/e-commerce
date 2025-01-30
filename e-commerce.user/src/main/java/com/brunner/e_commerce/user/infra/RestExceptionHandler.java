package com.brunner.e_commerce.user.infra;

import com.brunner.e_commerce.user.domain.exceptions.AddressEntityNotFoundException;
import com.brunner.e_commerce.user.domain.exceptions.UserEntityNotFoundException;
import com.brunner.e_commerce.user.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AddressEntityNotFoundException.class)
    private ResponseEntity<ExceptionDTO> addressNotFoundException(AddressEntityNotFoundException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Address not found on system!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

    @ExceptionHandler(UserEntityNotFoundException.class)
    private ResponseEntity<ExceptionDTO> userNotFoundException(UserEntityNotFoundException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usuário não encontrado no sistema!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }
}
