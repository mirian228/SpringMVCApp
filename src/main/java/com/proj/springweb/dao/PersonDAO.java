package com.proj.springweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.proj.springweb.models.Person;

@Component
public class PersonDAO {
	private static int PEOPLE_COUNT;

	private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "beenve111";

	private static Connection connection;

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Person> getAllPeople() {
		List<Person> people = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			String SQL = "SELECT * FROM Person";
			ResultSet resultSet = statement.executeQuery(SQL);

			while (resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt("id"));
				person.setAge(resultSet.getInt("age"));
				person.setName(resultSet.getString("name"));
				person.setEmail(resultSet.getString("email"));
				people.add(person);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return people;
	}

	public Person getPerson(int id) {
		// people.stream().filter(person -> person.getId() ==
		// id).findAny().orElse(null);
		return null;
	}

	public void save(Person person) {
//		person.setId(++PEOPLE_COUNT);
//		people.add(person);

		try {
			Statement statement = connection.createStatement();
			String SQL = "INSERT INTO Person VALUES (" + 1 + ",'" + person.getName() + "'," + person.getAge()
					+ ",'" + person.getEmail() + "')";
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int id, Person updatedPerson) {
//		Person personToBeUpdated = getPerson(id);
//		personToBeUpdated.setName(updatedPerson.getName());
//		personToBeUpdated.setEmail(updatedPerson.getEmail());
//		personToBeUpdated.setAge(updatedPerson.getAge());
//		
	}

	public void delete(int id) {
//		people.removeIf(person -> person.getId() == id);
	}
}
