package com.demo.springboot.hibernatejpademo.jpa;

import com.demo.springboot.hibernatejpademo.entity.PersonEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    EntityManager em;

    public PersonEntity findById(int id){
        return em.find(PersonEntity.class,id);
    }

    //insert and update uses same merge(), if Id present in Entity then insert otherwise update
    public PersonEntity update(PersonEntity person){
        return em.merge(person);
    }

    public PersonEntity insert(PersonEntity person){
        return em.merge(person);
    }

    public void deleteById(int id){
        PersonEntity person = findById(id);
        em.remove(person);
    }

    public List<PersonEntity> findAll(){
        TypedQuery<PersonEntity> namedQuery = em.createNamedQuery("find_all_person",PersonEntity.class);
        return namedQuery.getResultList();
    }
}
