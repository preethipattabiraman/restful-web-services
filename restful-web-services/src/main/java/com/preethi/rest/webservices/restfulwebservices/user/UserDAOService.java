package com.preethi.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	// JPA/Hibernate to call -> database
	// For now - UserDAOService -> static lists

	private static List<User> users = new ArrayList<>();
	private static int count = 0;
	static {
		users.add(new User(++count, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++count, "Eve", LocalDate.now().minusYears(20)));
		users.add(new User(++count, "John", LocalDate.now().minusYears(40)));
	}

	// findAll
	public List<User> findAll() {
		return users;
	}

	// saveUser
	public User saveUser(User user) {
		user.setId(++count);
		users.add(user);
		return user;
	}

	// findOne
	public User findOne(int id) {
		return users.stream()
				.filter(u -> u.getId() == id)
				.findFirst()
				.orElse(null);
	}

}
