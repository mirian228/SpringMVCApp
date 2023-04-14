package com.proj.springweb.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.proj.springweb.models.Person;

@Component
public class PersonDAO {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public PersonDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Person> getAllPeople() {
		return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
	}

	public Person getPerson(int id) {
		return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[] { id },
				new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
	}

	public void save(Person person) {
		jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?)", person.getName(), person.getAge(),
				person.getEmail());
	}

	public void update(int id, Person updatedPerson) {
		jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?", updatedPerson.getName(),
				updatedPerson.getAge(), updatedPerson.getEmail(), updatedPerson.getId());
	}

	public void delete(int id) {
		jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
	}
}
