package com.example.jpa.jpa.repository;

import com.example.jpa.jpa.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class,id);
    }

    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course){
        if(course.getId() != null){
            em.merge(course);
        }else{
            em.persist(course);
        }
        return course;
    }

    public void noNeedToPersistAsEMTracking(){
        Course course1 = new Course("course1");
        em.persist(course1);
        course1.setName("course1 updated");
        // no need to add -> em.persist(course1), as entityManager tracking entity course1 because of line(em.persist(course1)
    }

    //PersistenceContext keeps track of all the changes in entities that need to be stored in DB
    public void playWithEntityManager(){
        Course course1 = new Course("course1");
        Course course2 = new Course("course2");
        Course course3 = new Course("course3");
        em.persist(course1);
        em.persist(course2);
        em.persist(course3);

        em.flush();// write sql to DB,actual write happens here
        em.detach(course1); // now EM will not manage course1
        //em.clear(); // will detach all entities from EM
        course1.setName("course1 updated"); // will not be updated as EM not managing course1
        course2.setName("course2 updated");
        course3.setName("course3 updated"); // course3 will only be updated
        em.refresh(course2); // will discard any update to entity(course2), and will fetch data from DB
    }

}
