package com.custom.datasources.model;

public class Student {
    private String first_name;
    private String last_name;
    private int course_id;
    private int hall_id;

    public Student(){}

    public Student(String first_name, String last_name, int course_id, int hall_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.course_id = course_id;
        this.hall_id = hall_id;
    }

    public String getFirst_name() {
        return first_name;
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

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getHall_id() {
        return hall_id;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }
}
