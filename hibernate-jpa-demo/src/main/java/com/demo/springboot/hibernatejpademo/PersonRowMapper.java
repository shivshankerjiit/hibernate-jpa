package com.demo.springboot.hibernatejpademo;

import com.demo.springboot.hibernatejpademo.entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setDob(rs.getTimestamp("dob"));
        return person;
    }
}
