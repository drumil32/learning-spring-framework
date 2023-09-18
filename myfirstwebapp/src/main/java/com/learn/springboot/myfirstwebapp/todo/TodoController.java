package com.learn.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@RequestMapping("todos")
	public String getAllTodoForUser(ModelMap model) {
		model.put("todos", todoService.findByUsername("drumil"));
		return "listTodos";
	}
}
