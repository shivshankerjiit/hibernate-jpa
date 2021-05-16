package com.example.jpa.jpa.repository;

import com.example.jpa.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

//NativeQuery -> sql query
//JPQL Query -> query from Entity
@SpringBootTest
public class JpqlTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void jpql_basic(){
        Query query = em.createQuery("Select c from Course c");
        List resultList = query.getResultList();
        logger.info("Select c from Course c, {}",resultList);
    }
    @Test
    void jpql_typed_basic(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c", Course.class);
        List resultList = query.getResultList();
        logger.info("Select c from Course c, {}",resultList);
    }
    @Test
    void jpql_typed_where(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%JPA%'", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c, {}",resultList);
    }
    @Test
    void jpql_named_query(){
        TypedQuery<Course> query = em.createNamedQuery("query_select_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c, {}",resultList);
    }
    @Test
    void native_query_basic(){
        Query query = em.createNativeQuery("Select * from Course", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c, {}",resultList);
    }
    @Test
    void native_query_position_parameter(){
        Query query = em.createNativeQuery("Select * from Course where name id = ?", Course.class);
        query.setParameter(1, 10001L);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c, {}",resultList);
    }
    @Test
    void native_query_named_parameter(){
        Query query = em.createNativeQuery("Select * from Course where name id = :id", Course.class);
        query.setParameter("id", 10001L);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c, {}",resultList);
    }
    @Test
    void native_query_update(){
        Query query = em.createNativeQuery("Update Course set last_updated_date = sysdate()");
        int noOfRowsUpdated = query.executeUpdate();
        logger.info("No Of Rows Updated, {}",noOfRowsUpdated);
    }
}
