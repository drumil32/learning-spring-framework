package com.learning.learnspringsecurity.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static final List<Todo> TODOS_LIST = 
			List.of(
					new Todo("drumil","docker"),
					new Todo("drumil","AWS"),
					new Todo("jash","k8s")
			);

	@GetMapping("/todos")
	public List<Todo> retriveAllTodos(){
		return TODOS_LIST;
	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTodosForSpecificUser(@PathVariable String username) {
	    return TODOS_LIST.stream()
	            .filter(todo -> todo.username().equals(username))
	            .collect(Collectors.toList());
	}
	
	@PostMapping("/users/{username}/todos")
	public void createTodoForSpecificUser(@PathVariable String username,@RequestBody Todo todo) {
		logger.info("Create todo {} for {}",todo,username);
	}

}
record Todo(String username,String description) {}