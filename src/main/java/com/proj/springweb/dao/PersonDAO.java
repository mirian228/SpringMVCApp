package com.proj.springweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		Person person = null;
		try {
			PreparedStatement preparedStatement;
			String SQL = "SELECT * FROM PERSON WHERE id=?";
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();

			person = new Person();
			person.setAge(resultSet.getInt("age"));
			person.setName(resultSet.getString("name"));
			person.setEmail(resultSet.getString("email"));
			person.setId(resultSet.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person;
	}

	public void save(Person person) {

		try {
			String SQL = "INSERT INTO Person VALUES (1, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(SQL);
			statement.setString(1, person.getName());
			statement.setInt(2, person.getAge());
			statement.setString(3, person.getEmail());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int id, Person updatedPerson) {

		try {
			String SQL = "UPDATE Person SET name=?, age=?, email=? WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, updatedPerson.getName());
			preparedStatement.setInt(2, updatedPerson.getAge());
			preparedStatement.setString(3, updatedPerson.getEmail());
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {

		try {
			String SQL = "DELETE FROM Person WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
