package com.brunner.e_commerce.user.services.contracts;

import com.brunner.e_commerce.user.domain.User;
import com.brunner.e_commerce.user.domain.exceptions.AddressEntityNotFoundException;
import com.brunner.e_commerce.user.domain.exceptions.UserEntityNotFoundException;

import java.util.List;

public interface GenericService<T, T1> {
    public List<T1> findAll() throws AddressEntityNotFoundException, UserEntityNotFoundException;
    public T1 create(T entity) throws AddressEntityNotFoundException, UserEntityNotFoundException;
    public T1 update(T entity) throws AddressEntityNotFoundException, UserEntityNotFoundException;
    public T1 delete(String id) throws AddressEntityNotFoundException, UserEntityNotFoundException;
}
