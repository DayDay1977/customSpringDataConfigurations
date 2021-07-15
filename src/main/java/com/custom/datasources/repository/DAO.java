package com.custom.datasources.repository;

import java.util.List;

public interface DAO<T> {

    List<T> getAll();

    T create(T t);

    T update(T t, int id);

    int delete(int id);

    T getById(int id);
}
