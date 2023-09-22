package com.learning.rest.webservices.restfulwebservices.filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping("/users-filtering") 
	public List<User> retriveAllUsers(){
		List<User> arr = new ArrayList<>();
		arr.add(new User("drumil","123",1,"a@gm.com"));
		arr.add(new User("raxit","345",2,"r@gm.com"));
		arr.add(new User("meet","456",3,"g@gm.com"));
		arr.add(new User("jay","789",4,"k@gm.com"));
		return arr;
	}
}
