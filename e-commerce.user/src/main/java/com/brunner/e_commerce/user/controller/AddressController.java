package com.brunner.e_commerce.user.controller;

import com.brunner.e_commerce.user.domain.exceptions.AddressEntityNotFoundException;
import com.brunner.e_commerce.user.domain.exceptions.UserEntityNotFoundException;
import com.brunner.e_commerce.user.dto.AddressDto;
import com.brunner.e_commerce.user.dto.AddressViewDto;
import com.brunner.e_commerce.user.services.contracts.AddressService;
import com.brunner.e_commerce.user.services.contracts.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService service;

    @Autowired
    public AddressController(AddressService service) {
        this.service = service;
    }
    //todo: endpoint for filtering city, country and states
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AddressViewDto>> getAllUserAddresses(@PathVariable String userId) throws AddressEntityNotFoundException {
        if(userId.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<AddressViewDto> addresses = service.findAllByUserId(userId);
        if(addresses.isEmpty()){
            return new ResponseEntity<>(addresses,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<AddressViewDto> create(@RequestBody @Valid AddressDto dto) throws UserEntityNotFoundException, AddressEntityNotFoundException {
        if(dto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AddressViewDto result = service.create(dto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AddressViewDto> update(@PathVariable String id, @RequestBody AddressDto entity) throws UserEntityNotFoundException, AddressEntityNotFoundException {
        if(id.isEmpty() || entity == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AddressViewDto result =  service.update(entity);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddressViewDto> delete(@PathVariable String id) throws UserEntityNotFoundException, AddressEntityNotFoundException {
        if(id.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AddressViewDto result = service.delete(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
