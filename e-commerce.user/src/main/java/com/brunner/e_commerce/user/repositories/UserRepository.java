package com.brunner.e_commerce.user.repositories;

import com.brunner.e_commerce.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    public User findUserByCpf(String cpf);
    public User findUserByEmail(String email);

}
