package com.brunner.e_commerce.user.services.implementations;

import com.brunner.e_commerce.user.domain.Address;
import com.brunner.e_commerce.user.domain.User;
import com.brunner.e_commerce.user.domain.exceptions.UserEntityNotFoundException;
import com.brunner.e_commerce.user.dto.UserDTO;
import com.brunner.e_commerce.user.dto.UserViewDTO;
import com.brunner.e_commerce.user.repositories.UserRepository;
import com.brunner.e_commerce.user.services.contracts.UserService;
import com.brunner.e_commerce.user.util.mapper.UserDataMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserViewDTO findById(String id) throws UserEntityNotFoundException {
        User entity = repository.findById(id)
                .orElseThrow(UserEntityNotFoundException::new);
        return UserDataMapper.mapEntityToViewDto(entity);
    }

    @Override
    public List<UserViewDTO> findAll() throws UserEntityNotFoundException {
        List<User> users = repository.findAll();
        if (users.isEmpty()){
            throw new UserEntityNotFoundException();
        }
        return UserDataMapper.mapEntityListToViewDtoList(users);
    }

    @Override
    public UserViewDTO findByEmail(String email) throws UserEntityNotFoundException {
        User user = repository.findUserByEmail(email).orElseThrow(() ->
                new UserEntityNotFoundException("Entity not found with given email"));
        return UserDataMapper.mapEntityToViewDto(user);
    }

    @Override
    public UserViewDTO findByCpf(String cpf) throws UserEntityNotFoundException {
        User user = repository.findUserByCpf(cpf)
                .orElseThrow(() -> new UserEntityNotFoundException("Entity not found with given cpf"));
        return UserDataMapper.mapEntityToViewDto(user);
    }


    @Override
    public UserViewDTO create(UserDTO entity) {
        User mappedEntity = UserDataMapper.mapDtoToEntity(entity);
        //todo: cpf and email validations
        var result = repository.saveAndFlush(mappedEntity);

        return UserDataMapper.mapEntityToViewDto(result);
    }

    @Override
    public UserViewDTO update(UserDTO entity) throws UserEntityNotFoundException {
        User user = repository.findById(entity.id())
                .orElseThrow(() -> new UserEntityNotFoundException("Usuário não encontrado!"));
        //todo: cpf and email validations
        user = UserDataMapper.mapDtoToEntity(entity);
        repository.saveAndFlush(user);
        return UserDataMapper.mapEntityToViewDto(user);
    }

    @Override
    public UserViewDTO delete(String id) throws UserEntityNotFoundException {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserEntityNotFoundException("Usuário não encontrado!"));

        repository.delete(user);

        return UserDataMapper.mapEntityToViewDto(user);
    }


    @Override
    public UserDTO findDtoById(String id) throws UserEntityNotFoundException {
        var user = repository.findById(id)
                .orElseThrow(() -> new UserEntityNotFoundException());

        return UserDataMapper.mapEntityToDto(user);
    }
}
