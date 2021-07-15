package com.custom.datasources.model;

public class Hall {
    private String hall_name;

    private int hall_capacity;

    public Hall(){}

    public Hall(String hall_name){
        this.hall_name = hall_name;
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


}
