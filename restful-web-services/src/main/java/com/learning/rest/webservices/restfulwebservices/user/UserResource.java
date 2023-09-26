package com.learning.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.rest.webservices.restfulwebservices.JpaRepository.PostRepository;
import com.learning.rest.webservices.restfulwebservices.JpaRepository.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserResource {

//	private UserDaoService userDaoService;
	private final UserRepository userRepository;
	private final PostRepository postRepository;

	public UserResource(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@GetMapping(path = "/users")
	public List<User> retriveAllUsers() {
//		return userDaoService.findAll();
		return userRepository.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable Integer id) {
//		User user = userDaoService.findById(id);

		User user = userRepository.findById(id).orElse(null);
		;

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
		userRepository.deleteById(id);
	}

	@GetMapping(path = "/users/{username}/posts")
	public List<Post> retrivePostsForUser(@PathVariable String username) {
		User user = userRepository.findByUsername(username).orElse(null);
		;

		if (null == user)
			throw new UserNotFoundException("user with username :- " + username + " not found");
		return user.getPost();
	}

	@GetMapping(path = "/users/{username}/posts/{postId}")
	public Post retrivePostByIdForUser(@PathVariable String username, @PathVariable int postId) {
		User user = userRepository.findByUsername(username).orElse(null);

		if (null == user)
			throw new UserNotFoundException("user with username :- " + username + " not found");

		Predicate<? super Post> predicate = post -> post.getId() == postId;
		List<Post> posts = user.getPost();
		Post post = posts.stream().filter(predicate).findFirst().orElse(null);
		if (null == post)
			throw new PostNotFoundException("post with id :- " + postId + " not found");
		return post;
	}

	@DeleteMapping(path = "/users/{username}/posts/{postId}")
	public void deletePostByIdForUser(@PathVariable String username, @PathVariable int postId) {
		User user = userRepository.findByUsername(username).orElse(null);

		if (user == null)
			throw new UserNotFoundException("User with username: " + username + " not found");

		List<Post> posts = user.getPost();

		// Find the post with the specified postId
		Post postToDelete = posts.stream().filter(post -> post.getId() == postId).findFirst().orElse(null);

		if (postToDelete == null)
			throw new PostNotFoundException("Post with id: " + postId + " not found");

		// Use Spring Data JPA to delete the post from the database
		postRepository.deleteById(postToDelete.getId());
	}

	@PutMapping(path = "/users/{username}/posts")
	public ResponseEntity<Post> updatePostByIdForUser(@PathVariable String username, @Valid @RequestBody Post newPost) {
		User user = userRepository.findByUsername(username).orElse(null);

		if (null == user)
			throw new UserNotFoundException("user with username :- " + username + " not found");

		List<Post> posts = user.getPost();

		// Find the post with the specified postId
		Post postToUpdate = posts.stream().filter(post -> post.getId() == newPost.getId()).findFirst().orElse(null);

		if (postToUpdate == null)
			throw new PostNotFoundException("Post with id: " + newPost.getId() + " not found");
		

		newPost.setUser(user);
		Post savedPost = postRepository.save(newPost);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
				.buildAndExpand(savedPost.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PostMapping(path = "/users/{username}/posts")
	public ResponseEntity<Post> createPostForUser(@PathVariable String username, @Valid @RequestBody Post post) {
		User user = userRepository.findByUsername(username).orElse(null);

		if (null == user)
			throw new UserNotFoundException("user with username :- " + username + " not found");
		post.setUser(user);
		Post savedPost = postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
				.buildAndExpand(savedPost.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
