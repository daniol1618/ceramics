package com.example.ceramics.service;

import java.util.List;

public interface ICrudService<T, ID> {

    T create(T request);

    T getById(ID id);

    List<T> getAll();

    T update(ID id, T request);

    void deleteById(ID id);


}
