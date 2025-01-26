package com.brunner.e_commerce.user.services.contracts;

public interface UserService<T,T1> extends GenericService<T, T1>{
    public T1 findById(String id);
    public T1 findByEmail(String email);
    public T1 findByCpf(String cpf);
}
