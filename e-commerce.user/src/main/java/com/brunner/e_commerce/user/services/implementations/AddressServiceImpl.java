package com.brunner.e_commerce.user.services.implementations;

import com.brunner.e_commerce.user.domain.Address;
import com.brunner.e_commerce.user.domain.User;
import com.brunner.e_commerce.user.domain.exceptions.AddressEntityNotFoundException;
import com.brunner.e_commerce.user.domain.exceptions.UserEntityNotFoundException;
import com.brunner.e_commerce.user.dto.AddressDto;
import com.brunner.e_commerce.user.dto.AddressViewDto;
import com.brunner.e_commerce.user.dto.UserDTO;
import com.brunner.e_commerce.user.repositories.AddressRepository;
import com.brunner.e_commerce.user.services.contracts.AddressService;
import com.brunner.e_commerce.user.services.contracts.UserService;
import com.brunner.e_commerce.user.util.mapper.AddressDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final UserService userService;

    @Autowired
    public AddressServiceImpl(AddressRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }
    //todo: métodos de filtragem por cidade, estado e país
    @Override
    public List<AddressViewDto> findAllByUserId(String id) throws AddressEntityNotFoundException {
        List<Address> addresses = repository.getAllAddressByUserId(id);
        if(addresses.isEmpty()){
            throw new AddressEntityNotFoundException("Nenhum endereço encontrado para esse usuário!");
        }

        return AddressDataMapper.mapListEntityToViewDto(addresses);
    }

    @Override
    public List<AddressViewDto> findAll() throws AddressEntityNotFoundException {
        List<Address> addresses = repository.findAll();
        if(addresses.isEmpty()){
            throw new AddressEntityNotFoundException("Nenhum endereço encontrado no sistema");
        }

        return AddressDataMapper.mapListEntityToViewDto(addresses);
    }

    @Override
    public AddressViewDto create(AddressDto entity) throws AddressEntityNotFoundException, UserEntityNotFoundException {
        Address address = AddressDataMapper.mapDtoToEntity(entity);

        if(address.isMain()){
            getAndUpdateUser(address.getUser().getId(), address);
        }
        repository.saveAndFlush(address);
        return AddressDataMapper.mapEntityToViewDto(address);
    }

    @Override
    public AddressViewDto update(AddressDto entity) throws AddressEntityNotFoundException, UserEntityNotFoundException {
        Address address = repository.findById(entity.id())
                .orElseThrow(() -> new AddressEntityNotFoundException());
        address = AddressDataMapper.mapDtoToEntity(entity);

        if(address.isMain()){
            getAndUpdateUser(address.getUser().getId(), address);
        }

        return AddressDataMapper.mapEntityToViewDto(address);
    }

    @Override
    public AddressViewDto delete(String id) throws AddressEntityNotFoundException, UserEntityNotFoundException {
        Address address = repository.findById(id)
                .orElseThrow(() -> new AddressEntityNotFoundException());

        if(address.isMain()){
            getAndUpdateUser(address.getUser().getId(), null);
        }

        return AddressDataMapper.mapEntityToViewDto(address);
    }

    private void getAndUpdateUser(String id, Address newAddress) throws AddressEntityNotFoundException, UserEntityNotFoundException {
        var user = userService.findDtoById(newAddress.getUser().getId());
        UserDTO updatedUser = UserDTO.builder()
                .id(user.id())
                .cpf(user.cpf())
                .password(user.password())
                .email(user.email())
                .firstName(user.firstName())
                .lastName(user.lastName())
                .mainAddress(newAddress)
                .userType(user.userType())
                .build();
        userService.update(updatedUser);
    }

}