package com.demo.springboot.hibernatejpademo.jpa;


import com.demo.springboot.hibernatejpademo.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @PersistenceContext
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class,id);
    }
    public void deleteById(Long id){
        Course course = findById(1001L);
        em.remove(course);
    }
    public Course save(Course course){
        if(course.getId() != null){
            em.persist(course);
        }else{
            em.merge(course);
        }
        return course;
    }
    //inside transaction, EntityManager manages entities untill end of transaction
    //no need to save explictly, -> em.merge();
    public void playWithEntityManager(){
        Course course = new Course("ELON");
        em.persist(course);
        course.setName("MUSK");
    }
    //em.flush() -> push entity to db
    //em.refresh(course1) -> pull content from db
    //em.detach(course1) -> detach entity from PersistenceContext
    //em.clear() -> detach all entites from PersistenceContext'
    public void playWithEntityManager2(){
        Course course1 = new Course("LIZA");
        Course course2 = new Course("JORICA");
        em.persist(course1);
        em.persist(course2);
        em.flush();

        em.detach(course1);
        em.detach(course2);
        //em.clear();
        course1.setName("RAY");
        course1.setName("TATIA");
        em.refresh(course1);
        em.flush();
    }
    public void jpql_basic(){
        Query query = em.createQuery("select p from Course p");
        List<Course> courses = query.getResultList();
    }
    public void jpql_typed(){
        TypedQuery<Course> typedQuery = em.createQuery("select p from Course p",Course.class);
        List<Course> courses = typedQuery.getResultList();
    }
    public void jpql_where(){
        TypedQuery<Course> typedQuery = em.createNamedQuery("select c from Course c where name like '%JA%'",Course.class);
        List<Course> courses = typedQuery.getResultList();
    }
    public void jpql_namedQuery(){
        TypedQuery<Course> query = em.createNamedQuery("get_all_coures",Course.class);
        List<Course> courses = query.getResultList();
    }
    public void jpql_nativeQuery_with_positionParam(){
        Query query = em.createNativeQuery("select * from Course where name = ?",Course.class);
        query.setParameter(1,"JACK");
        List<Course> courses = query.getResultList();
    }
    public void jpql_nativeQuery_with_namedParam(){
        Query query = em.createNativeQuery("select * from Course where name = :name",Course.class);
        query.setParameter("name","JACK");
        List<Course> courses = query.getResultList();
    }
    @Transactional
    public void jpql_nativeQuery_update(){
        Query query = em.createNativeQuery("update course set update_timestamp=sysdate()",Course.class);
        int noOfRowsUpdated = query.executeUpdate();
    }
}
