package com.custom.datasources.model;

public class Hall {

    private int hall_id;
    private String hall_name;
    private int hall_capacity;

    public Hall(){}

    public Hall(int hall_id, String hall_name, int hall_capacity) {
        this.hall_id = hall_id;
        this.hall_name = hall_name;
        this.hall_capacity = hall_capacity;
    }

    public String getHall_name(){
        return hall_name;
    }

    public void setHall_name(String hall_name){
        this.hall_name = hall_name;
    }

    public int getHall_capacity() {
        return hall_capacity;
    }

    public void setHall_capacity(int hall_capacity) {
        this.hall_capacity = hall_capacity;
    }

    public int getHall_id() {
        return hall_id;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }
}
