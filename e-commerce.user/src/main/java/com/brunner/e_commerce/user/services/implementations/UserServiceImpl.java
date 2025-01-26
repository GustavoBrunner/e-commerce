package com.brunner.e_commerce.user.services.implementations;

import com.brunner.e_commerce.user.dto.UserDTO;
import com.brunner.e_commerce.user.dto.UserViewDTO;
import com.brunner.e_commerce.user.repositories.UserRepository;
import com.brunner.e_commerce.user.services.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService<UserDTO, UserViewDTO> {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserViewDTO findById(String id) {
        return null;
    }

    @Override
    public List<UserViewDTO> findAll() {
        return List.of();
    }

    @Override
    public UserViewDTO findByEmail(String email) {
        return null;
    }

    @Override
    public UserViewDTO findByCpf(String cpf) {
        return null;
    }

    @Override
    public UserViewDTO create(UserDTO entity) {
        return null;
    }

    @Override
    public UserViewDTO update(UserDTO entity) {
        return null;
    }

    @Override
    public UserViewDTO delete(String id) {
        return null;
    }
}
