package com.preethi.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
	// HATEOAS
	// EntityModel - wrap the User into EntityModel and WebMvcLinkBuilder - build
	// URL as a part of User response
	@GetMapping("/users/{id}")
	public EntityModel<User> getOne(@PathVariable int id) {
		User foundUser = userDAOService.findOne(id);
		if (foundUser == null)
			throw new UserNotFoundException("User id : " + id + " not found");
		EntityModel<User> entityModel = EntityModel.of(foundUser);
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	// POST /users
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userDAOService.saveUser(user);
		// Return the location of the newly created user
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		// Location header - /users/{id}
		return ResponseEntity.created(location).build();
	}

	// DELETE /users/{id}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userDAOService.deleteById(id);
	}

}
