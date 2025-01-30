package com.brunner.e_commerce.user.controller;

import com.brunner.e_commerce.user.domain.exceptions.AddressEntityNotFoundException;
import com.brunner.e_commerce.user.domain.exceptions.UserEntityNotFoundException;
import com.brunner.e_commerce.user.dto.UserDTO;
import com.brunner.e_commerce.user.dto.UserViewDTO;
import com.brunner.e_commerce.user.services.contracts.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserViewDTO>> getAll() throws AddressEntityNotFoundException, UserEntityNotFoundException {
        List<UserViewDTO> users = service.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserViewDTO> getById(@PathVariable String id) throws UserEntityNotFoundException {
        if(id.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserViewDTO result = service.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserViewDTO> getByEmail(@PathVariable("email") String email) throws UserEntityNotFoundException {
        UserViewDTO user = service.findByEmail(email);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UserViewDTO> getByCpf(@PathVariable("cpf") String cpf) throws UserEntityNotFoundException {
        UserViewDTO user = service.findByCpf(cpf);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserViewDTO> create(@RequestBody @Valid UserDTO dto) throws AddressEntityNotFoundException, UserEntityNotFoundException {
        if(dto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var result = service.create(dto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserViewDTO> update(@PathVariable String id,@RequestBody @Valid UserDTO dto) throws UserEntityNotFoundException, AddressEntityNotFoundException {
        if(dto == null || id.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var result = service.update(dto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserViewDTO> delete(@PathVariable String id) throws AddressEntityNotFoundException, UserEntityNotFoundException {
        if(id.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserViewDTO result = service.findById(id);

        service.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}