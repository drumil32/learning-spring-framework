package com.learn.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	
	static {
		todos.add(new Todo(1,"aws","aws cloud",LocalDate.now().plusMonths(2),false));
		todos.add(new Todo(1,"docker","containerzation",LocalDate.now().plusMonths(3),false));
		todos.add(new Todo(1,"k8s","container orcastrator",LocalDate.now().plusMonths(4),false));
		todos.add(new Todo(1,"azure","azure cloud",LocalDate.now().plusMonths(6),false));
		todos.add(new Todo(1,"python","py programming",LocalDate.now().plusMonths(9),false));
	}
	public static List<Todo> findByUsername(String username){
		return todos;
	}
}
