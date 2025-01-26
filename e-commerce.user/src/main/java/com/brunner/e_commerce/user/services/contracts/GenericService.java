package com.brunner.e_commerce.user.services.contracts;

import com.brunner.e_commerce.user.domain.User;

import java.util.List;

public interface GenericService<T, T1> {
    public List<T1> findAll();
    public T1 create(T entity);
    public T1 update(T entity);
    public T1 delete(String id);
}
