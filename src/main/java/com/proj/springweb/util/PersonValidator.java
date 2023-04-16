package com.proj.springweb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.proj.springweb.dao.PersonDAO;
import com.proj.springweb.models.Person;

@Component
public class PersonValidator implements Validator {
	private final PersonDAO personDAO;

	@Autowired
	PersonValidator(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person person = (Person) target;

		if (personDAO.getPersonWithEmail(person.getEmail()).isPresent()) {
			errors.rejectValue("email", "This email is already taken");
		}

	}

}
