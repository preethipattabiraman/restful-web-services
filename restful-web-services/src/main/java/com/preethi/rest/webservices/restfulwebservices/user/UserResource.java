package com.preethi.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	private UserDAOService userDAOService;

	public UserResource(UserDAOService userDAOService) {
		this.userDAOService = userDAOService;
	}

	// GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userDAOService.findAll();
	}

	// GET /users/{id}
	@GetMapping("/users/{id}")
	public User getOne(@PathVariable int id) {
		return userDAOService.findOne(id);
	}

	// POST /users
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		userDAOService.saveUser(user);
	}

}
