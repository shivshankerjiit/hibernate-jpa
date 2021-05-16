package com.demo.springboot.hibernatejpademo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="Course1")
@NamedQueries(value = {
        @NamedQuery(name="get_all_coures",query = "select p from Course p"),
        @NamedQuery(name="get_all_coures_where",query = "select p from Course p where name like '%JA%'")
})

//@Table(name="CourseDetail") -> 'course_detail' in db
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    //@Column(name="fullname",nullable = false,insertable = true,unique = false,updatable = true)
    private String name;

    @UpdateTimestamp
    private LocalDateTime updateTimestamp;

    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Course(String name) {
        this.name = name;
    }
    public Course() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
