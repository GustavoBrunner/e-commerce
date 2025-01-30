package com.brunner.e_commerce.user.services.contracts;

import com.brunner.e_commerce.user.domain.User;
import com.brunner.e_commerce.user.domain.exceptions.UserEntityNotFoundException;
import com.brunner.e_commerce.user.dto.UserDTO;
import com.brunner.e_commerce.user.dto.UserViewDTO;

public interface UserService extends GenericService<UserDTO, UserViewDTO>{
    public UserViewDTO findById(String id) throws UserEntityNotFoundException;
    public UserViewDTO findByEmail(String email) throws UserEntityNotFoundException;
    public UserViewDTO findByCpf(String cpf) throws UserEntityNotFoundException;
    public UserDTO findDtoById(String id) throws UserEntityNotFoundException;
    public User findEntityById(String id) throws  UserEntityNotFoundException;
    public void saveEntity(User newEntity);
}
