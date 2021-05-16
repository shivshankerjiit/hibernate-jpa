package com.demo.springboot.hibernatejpademo.oneToOne.jpa;

import com.demo.springboot.hibernatejpademo.entity.Course;
import com.demo.springboot.hibernatejpademo.oneToOne.entity.Passport;
import com.demo.springboot.hibernatejpademo.oneToOne.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @PersistenceContext
    EntityManager em;

    public Student findById(Long id){
        return em.find(Student.class,id);
    }
    public void deleteById(Long id){
        Student student = findById(1001L);
        em.remove(student);
    }
    public Student save(Student student){
        if(student.getId() != null){
            em.persist(student);
        }else{
            em.merge(student);
        }
        return student;
    }
    public void saveStudent(){
        Passport p = new Passport("Z11");
        Student s = new Student("Raj");
        s.setPassport(p);
        em.persist(s);
    }
    //em.flush() -> push entity to db
    //em.refresh(course1) -> pull content from db
    //em.detach(course1) -> detach entity from PersistenceContext
    //em.clear() -> detach all entites from PersistenceContext'
}
