package com.brunner.e_commerce.user.repositories;

import com.brunner.e_commerce.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    public Optional<User> findUserByCpf(String cpf);
    public Optional<User> findUserByEmail(String email);

}
