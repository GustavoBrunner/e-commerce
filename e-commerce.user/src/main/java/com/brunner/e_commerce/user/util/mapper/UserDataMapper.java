package com.brunner.e_commerce.user.util.mapper;

import com.brunner.e_commerce.user.domain.Address;
import com.brunner.e_commerce.user.domain.User;
import com.brunner.e_commerce.user.domain.exceptions.AddressEntityNotFoundException;
import com.brunner.e_commerce.user.dto.UserDTO;
import com.brunner.e_commerce.user.dto.UserViewDTO;
import com.brunner.e_commerce.user.repositories.AddressRepository;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class UserDataMapper {

    public static User mapDtoToEntity(UserDTO entity){
        User newUser = new User();
        BeanUtils.copyProperties(entity, newUser);
        return newUser;
    }
    public static UserDTO mapEntityToDto(User entity){
        return UserDTO.builder()
                .id(entity.getId())
                .password(entity.getPassword())
                .cpf(entity.getCpf())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .userType(entity.getUserType())
                .mainAddress(entity.getMainAddress())
                .build();
    }
    public static UserViewDTO userDtoToViewDto(UserDTO entity){
        return UserViewDTO.builder()
                .cpf(entity.cpf())
                .userType(entity.userType())
                .email(entity.email())
                .firstName(entity.firstName())
                .lastName(entity.lastName())
                .build();
    }
    public static UserViewDTO mapEntityToViewDto(User entity){
        return UserViewDTO.builder()
                .cpf(entity.getCpf())
                .userType(entity.getUserType())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }
    public static void updateEntityFromDto(User user, UserDTO dto, AddressRepository addressRepository) throws AddressEntityNotFoundException {
        user.setCpf(dto.cpf());
        user.setPassword(dto.password());
        user.setEmail(dto.email());
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setUserType(dto.userType());

        if (dto.mainAddress() != null) {
            //todo: create findbyid method on address service and change here
            Address managedAddress = addressRepository.findById(dto.mainAddress().getId())
                    .orElseThrow(() -> new AddressEntityNotFoundException());
            user.setMainAddress(managedAddress);
        }
    }
    public static List<UserViewDTO> mapEntityListToViewDtoList(List<User> entites){
        List<UserViewDTO> dtos = new ArrayList<>();
        for(User user : entites){
            dtos.add(UserDataMapper.mapEntityToViewDto(user));
        }
        return dtos;
    }
}
