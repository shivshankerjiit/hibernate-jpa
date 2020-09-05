package com.demo.springboot.hibernatejpademo.jdbc;

import com.demo.springboot.hibernatejpademo.PersonRowMapper;
import com.demo.springboot.hibernatejpademo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll(){
        return jdbcTemplate.query("SELECT * FROM PERSON", new BeanPropertyRowMapper<Person>(Person.class));
    }
    public Person findById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON where id=?", new Object[]{id},new BeanPropertyRowMapper<Person>(Person.class));
    }
    //return no of rows deleted
    public int deleteById(int id){
        return jdbcTemplate.update("DELETE FROM PERSON where id=?", new Object[]{id});
    }
    public int insert(Person person){
        return jdbcTemplate.update("INSERT INTO PERSON(ID,NAME,LOCATION,DOB) VALUES(?,?,?,?)",
                new Object[]{person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getDob().getTime())});
    }
    public int update(Person person){
        return jdbcTemplate.update("UPDATE PERSON SET NAME = ?, LOCATION = ? , DOB = ? WHERE ID=?",
                new Object[]{person.getName(),person.getLocation(),new Timestamp(person.getDob().getTime()),person.getId()});
    }
    public List<Person> findAllRowMapper(){
        return jdbcTemplate.query("select * from Person",new PersonRowMapper());
    }
}
