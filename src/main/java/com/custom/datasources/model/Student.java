package com.custom.datasources.model;


import java.util.List;

public class Student {
    private int id;
    private String student_id;
    private String first_name;
    private String last_name;
    private List<Course> courses;
    private Hall hall_name;

    public Student(){}

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Hall getHall_name() {
        return hall_name;
    }

    public void setHall_name(Hall hall_name) {
        this.hall_name = hall_name;
    }
}
