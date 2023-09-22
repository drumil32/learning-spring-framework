package com.learning.rest.webservices.restfulwebservices.filtering;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	private static List<User> arr = new ArrayList<>();
	
	static {
		arr.add(new User("drumil","123",1,"a@gm.com"));
		arr.add(new User("raxit","345",2,"r@gm.com"));
		arr.add(new User("meet","456",3,"g@gm.com"));
		arr.add(new User("jay","789",4,"k@gm.com"));
	}

	@GetMapping("/users-filtering") 
	public List<User> retriveAllUsers(){
		return arr;
	}
	
	@GetMapping("/users-filtering/{id}")
	public User retriveUserById(@PathVariable int id){
		Predicate<? super User> predicate = user -> user.getId()==id;
		return arr.stream()
			.filter(predicate)
			.findFirst()
			.orElse(null);
	}
	
	@GetMapping("/users-filtering-dynamic")
	public MappingJacksonValue retriveAllUsersDynamicFiltering(){
		List<User> users = arr;

	    MappingJacksonValue mapping = new MappingJacksonValue(users);
	    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id");
	    FilterProvider filters = new SimpleFilterProvider().addFilter("users-filtering-dynamic-filter", filter);
	    mapping.setFilters(filters);

	    return mapping;
	}
	
	@GetMapping("/users-filtering-dynamic/{id}")
	public MappingJacksonValue retriveUserDynamicById(@PathVariable int id){
		Predicate<? super User> predicate = user -> user.getId()==id;
		User user = arr.stream()
			.filter(predicate)
			.findFirst()
			.orElse(null);
	    MappingJacksonValue mapping = new MappingJacksonValue(user);
	    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username","emailId");
	    FilterProvider filters = new SimpleFilterProvider().addFilter("users-filtering-dynamic-filter", filter);
	    mapping.setFilters(filters);

	    return mapping;
	}
}
