package com.learn.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@RequestMapping("/todos")
	public String getAllTodoForUser(ModelMap model) {
		
		model.put("todos", todoService.findByUsername("drumil"));
		return "listTodos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String submitForm() {
		return "addTodo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(@RequestParam String description,@RequestParam LocalDate targetDate,ModelMap model) {
		String username = (String) model.get("name");
		todoService.addTodo(username,description,targetDate,false);
		return "redirect:todos";
	}
}
