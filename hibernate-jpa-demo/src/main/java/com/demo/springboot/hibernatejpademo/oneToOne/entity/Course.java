package com.demo.springboot.hibernatejpademo.oneToOne.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable=false)
    private String name;

    @CreationTimestamp
    private Timestamp created_date;

    @CreationTimestamp
    private Timestamp last_updated_date;

    public Course() {
    }

    public Course(String name, Timestamp created_date, Timestamp last_updated_date) {
        this.name = name;
        this.created_date = created_date;
        this.last_updated_date = last_updated_date;
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

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public Timestamp getLast_updated_date() {
        return last_updated_date;
    }

    public void setLast_updated_date(Timestamp last_updated_date) {
        this.last_updated_date = last_updated_date;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_date=" + created_date +
                ", last_updated_date=" + last_updated_date +
                '}';
    }
}
