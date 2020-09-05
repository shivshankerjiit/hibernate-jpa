package com.demo.springboot.hibernatejpademo.oneToOne.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    private String number;

    public Review() {
    }

    public Review(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
