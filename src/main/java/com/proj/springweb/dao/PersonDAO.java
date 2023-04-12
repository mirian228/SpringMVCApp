package com.proj.springweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.proj.springweb.models.Person;

@Component
public class PersonDAO {
	private static int PEOPLE_COUNT;
	private List<Person> people;

	{
		people = new ArrayList<>();

		people.add(new Person(++PEOPLE_COUNT, "Tom", 20, "tom@gmail.com"));
		people.add(new Person(++PEOPLE_COUNT, "Bob", 34, "bob@gmail.com"));
		people.add(new Person(++PEOPLE_COUNT, "Mike", 17, "mike@yahoo.com"));
		people.add(new Person(++PEOPLE_COUNT, "John", 37, "katy@gmail.com"));
	}

	public List<Person> getAllPeople() {
		return people;
	}

	public Person getPerson(int id) {
		return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
	}

	public void save(Person person) {
		person.setId(++PEOPLE_COUNT);
		people.add(person);
	}

	public void update(int id, Person updatedPerson) {
		Person personToBeUpdated = getPerson(id);
		personToBeUpdated.setName(updatedPerson.getName());
		personToBeUpdated.setEmail(updatedPerson.getEmail());
		personToBeUpdated.setAge(updatedPerson.getAge());
		
	}

	public void delete(int id) {
		people.removeIf(person -> person.getId() == id);
	}
}
