package com.custom.datasources.repository;

import java.util.List;

public interface StudentDAO<T> {

    List<T> getAll();

    T create(T t);

    T update(T t);

    int delete(T t);

    T getById(T t);
}
