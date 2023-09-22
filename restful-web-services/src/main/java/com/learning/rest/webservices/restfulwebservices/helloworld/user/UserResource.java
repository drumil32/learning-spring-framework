package com.learning.rest.webservices.restfulwebservices.helloworld.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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

	private UserDaoService userDaoService;
	private final UserRepository userRepository;

	public UserResource(UserDaoService service, UserRepository userRepository) {
		this.userDaoService = service;
		this.userRepository = userRepository;
	}

	@GetMapping(path = "/users")
	public List<User> retriveAllUsers() {
//		return userDaoService.findAll();
		return userRepository.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable Integer id) {
//		User user = userDaoService.findById(id);

		User user = userRepository.findById(id).orElse(null);;

		if (null == user)
			throw new UserNotFoundException("user with id :- " + id + " not found");

		EntityModel<User> entityModel = EntityModel.of(user);

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());
		entityModel.add(link.withRel("all-users"));

		return entityModel;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
//		User savedUser = userDaoService.save(user);
		
		User savedUser = userRepository.save(user);
		System.out.println(savedUser);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
//		userDaoService.deleteById(id);
		userRepository.deleteById(id);
	}
}
