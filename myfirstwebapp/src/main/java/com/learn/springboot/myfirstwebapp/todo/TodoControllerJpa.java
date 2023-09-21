package com.learn.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoControllerJpa {

	private TodoRepository todoRepository;
	
	public TodoControllerJpa(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@RequestMapping("/todos")
	public String getAllTodoForUser(ModelMap model) {
		String username = getLoggedInUsername();
		model.put("todos", todoRepository.findByUsername(username));
		return "listTodos";
	}

	private String getLoggedInUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodoForm(ModelMap model) {
		String username = getLoggedInUsername();
		Todo todo = new Todo(0,username,
				"Defalut desc",LocalDate.now(),false);
		model.put("todo", todo);
		return "addTodo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if( result.hasErrors() ) {
			return "addTodo";
		}
		todoRepository.save(todo);
		return "redirect:todos";
	}
	
	@RequestMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:todos";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String updateTodoForm(@RequestParam int id,ModelMap model) {
		Optional<Todo> todoOptional = todoRepository.findById(id);
		if( todoOptional.isPresent() ) {
			Todo todo = todoOptional.get();
			System.out.println(todo);
			model.put("todo",todo);
			
		}
		return "addTodo";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if( result.hasErrors() ) {
			return "addTodo";
		}
		todoRepository.save(todo);
		return "redirect:todos";
	}
}
