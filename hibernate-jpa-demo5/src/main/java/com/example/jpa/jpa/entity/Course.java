package com.example.jpa.jpa.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Table(name = "Course")
@NamedQueries(
        value={
                @NamedQuery(name="query_select_all_courses", query="Select c from Course c"),
                @NamedQuery(name="query_select_JPA_courses", query="Select c from Course c where name like '%JPA'")
        }
)
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    //@Column(name = "name",unique = true,nullable = false,updatable = true,insertable = true,length = 20,precision = 0)
    private String name;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedTime;
    @CreationTimestamp
    private LocalDateTime createdTime;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

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

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdatedTime=" + lastUpdatedTime +
                ", createdTime=" + createdTime +
                '}';
    }
}
