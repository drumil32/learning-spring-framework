package com.learn.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
	public String addTodoForm(ModelMap model) {
		String username = (String)model.get("usename");
		Todo todo = new Todo(0,username,"Defalut desc",LocalDate.now(),false);
		model.put("todo", todo);
		return "addTodo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if( result.hasErrors() ) {
			return "addTodo";
		}
		String username = (String) model.get("name");
		todoService.addTodo(username,todo.getDescription(),LocalDate.now().plusMonths(2),false);
		return "redirect:todos";
	}
	
	@RequestMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:todos";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String updateTodoForm(@RequestParam int id,ModelMap model) {
		Todo todo = todoService.findById(id);
		model.put("todo",todo);
		return "addTodo";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if( result.hasErrors() ) {
			return "addTodo";
		}
		String username = (String) model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:todos";
	}
}
