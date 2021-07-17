package com.custom.datasources.repository;

import java.util.List;

public interface StudentUtilsDAO<T> {

   // List<T> getAll();

    void addCourses(String s, List<Integer> t);

    String addHall(String s, int t);

    T update(T t);

    int delete(T t);

    T getDetails(String t);
}
