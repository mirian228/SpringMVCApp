package com.proj.springweb.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {

	private int id;
	@NotEmpty(message = "Field should not be empty")
	@Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
	private String name;
	@Min(value = 0, message = "Age can't be less than 0")
	private int age;
	@NotEmpty(message = "Email should not be empty")
	@Email
	private String email;
	// Country, City, Index (6 digits)
	// America, New York, 123456
	@Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your adress should be in this format: Country, City, Postal Code (6 digits)")
	private String address;

	public Person() {

	}

	public Person(int id, String name, int age, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
