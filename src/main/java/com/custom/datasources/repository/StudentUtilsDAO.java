package com.custom.datasources.repository;

import java.util.List;

public interface StudentUtilsDAO<T> {

    String addCourses(String s, List<Integer> t);

    String addHall(String s, int t);

    int removeCourses(String s);

    int editHall(String s, int t);

    T getDetails(String t);
}
