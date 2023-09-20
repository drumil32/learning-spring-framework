package com.learn.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.eclipse.tags.shaded.org.apache.xpath.axes.PredicatedNodeTest;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 0;
	
	static {
		todos.add(new Todo(++todoCount,"aws","aws cloud",LocalDate.now().plusMonths(2),false));
		todos.add(new Todo(++todoCount,"docker","containerzation",LocalDate.now().plusMonths(3),false));
		todos.add(new Todo(++todoCount,"k8s","container orcastrator",LocalDate.now().plusMonths(4),false));
		todos.add(new Todo(++todoCount,"azure","azure cloud",LocalDate.now().plusMonths(6),false));
		todos.add(new Todo(++todoCount,"python","py programming",LocalDate.now().plusMonths(9),false));
	}
	public static List<Todo> findByUsername(String username){
		return todos;
	}
	public void addTodo(String username,String description, LocalDate targetDate, boolean isCompleted) {
		todos.add(new Todo(++todoCount,username,description,targetDate,isCompleted));
	}
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		System.out.println(predicate);
		todos.removeIf(predicate);
	}
	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate 
			= todo -> todo.getId()==id;
		return todos.stream().filter(predicate).findFirst().get();
	}
	
}
