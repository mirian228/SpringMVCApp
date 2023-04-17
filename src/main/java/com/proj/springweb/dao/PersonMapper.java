package com.proj.springweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.proj.springweb.models.Person;

public class PersonMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		person.setEmail(rs.getString("email"));
		person.setAge(rs.getInt("age"));
		person.setAddress(rs.getString("address"));
		
		return person;
	}

}
