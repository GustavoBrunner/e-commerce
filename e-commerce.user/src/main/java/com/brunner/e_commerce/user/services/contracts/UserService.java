package com.brunner.e_commerce.user.services.contracts;

import com.brunner.e_commerce.user.dto.UserDTO;
import com.brunner.e_commerce.user.dto.UserViewDTO;

public interface UserService extends GenericService<UserDTO, UserViewDTO>{
    public UserViewDTO findById(String id);
    public UserViewDTO findByEmail(String email);
    public UserViewDTO findByCpf(String cpf);
    public UserDTO findDtoById(String id);

}
