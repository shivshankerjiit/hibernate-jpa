package com.demo.springboot.hibernatejpademo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name="find_all_person", query="select p from PersonEntity p")
@Table(name="Person")
public class PersonEntity {
    @Id
    @GeneratedValue
    int id;

    @Column(name="name")
    String name;
    String location;
    Date dob;

    // necessary for Spring JPA
    public PersonEntity(){}

    //remove id, as it will be generated
    public PersonEntity(String name, String location, Date dob) {
        super();
        this.name = name;
        this.location = location;
        this.dob = dob;
    }
    //EntityManager manages Entities, all the operation that we perform stored in PersistenceContext(is instance to EntityManager)
    public PersonEntity(int id, String name, String location, Date dob) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "\nPersonEntity{" +
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
