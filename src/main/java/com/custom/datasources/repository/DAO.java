package com.custom.datasources.repository;

import com.custom.datasources.model.Course;

import java.util.List;

public interface DAO<T> {

    List<T> getCourses();

    T create(T t);

    T update(T t, int id);

    void delete(int id);

    Course getById(int id);

    void insert(T t);
}
