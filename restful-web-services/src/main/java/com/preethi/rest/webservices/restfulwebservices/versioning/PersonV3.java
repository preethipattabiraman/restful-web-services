package com.preethi.rest.webservices.restfulwebservices.versioning;

public class PersonV3 {
	private String firstName;
	private String lastName;

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public PersonV3(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
