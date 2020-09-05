package com.demo.springboot.hibernatejpademo.entity;

import java.util.Date;

public class Person {
    int id;
    String name;
    String location;
    Date dob;

    // necessary for Spring JdbcTemplate
    public Person(){}

    public Person(int id, String name, String location, Date dob) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", dob=" + dob +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
