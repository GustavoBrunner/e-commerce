package com.brunner.e_commerce.user.util.mapper;

import com.brunner.e_commerce.user.domain.User;
import com.brunner.e_commerce.user.dto.UserDTO;
import com.brunner.e_commerce.user.dto.UserViewDTO;
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
        return new UserDTO(entity.getId(),entity.getEmail(), entity.getCpf(),
                entity.getPassword(),entity.getFirstName(), entity.getLastName(),
                entity.getUserType());
    }
    public static UserViewDTO userViewDtoToDto(UserDTO entity){
        return new UserViewDTO(entity.email(), entity.cpf(),
                entity.firstName(), entity.lastName(),
                entity.userType());
    }
    public static UserViewDTO mapEntityToViewDto(User entity){
        return new UserViewDTO(entity.getEmail(), entity.getCpf(),
                entity.getFirstName(), entity.getLastName(),
                entity.getUserType());
    }
    public static List<UserViewDTO> mapEntityListToViewDtoList(List<User> entites){
        List<UserViewDTO> dtos = new ArrayList<>();
        for(User user :entites){
            dtos.add(UserDataMapper.mapEntityToViewDto(user));
        }
        return dtos;
    }
}
