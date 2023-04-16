package com.preethi.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User foundUser = userDAOService.findOne(id);
		if(foundUser == null)
			throw new UserNotFoundException("User id : " + id + " not found");
		return foundUser;
	}

	// POST /users
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userDAOService.saveUser(user);
		//Return the location of the newly created user
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		// Location header - /users/{id}
		return ResponseEntity.created(location).build();
	}

}
