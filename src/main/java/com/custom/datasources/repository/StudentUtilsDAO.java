package com.custom.datasources.repository;

import java.util.List;

public interface StudentUtilsDAO<T> {

    String addCourses(String s,int q, List<Integer> t);

    int removeCourses(String s);

    int editHall(String s, int t);

    T getDetails(String t);
}
