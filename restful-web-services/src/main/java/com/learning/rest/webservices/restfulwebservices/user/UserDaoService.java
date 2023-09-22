package com.learning.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static Integer count = 0;
	static {
//		users.add(new User(++count,"Drumil",LocalDate.now().minusDays(2)));
//		users.add(new User(++count,"Raxit",LocalDate.now()));
//		users.add(new User(++count,"Meet",LocalDate.now()));
//		users.add(new User(++count,"Jay",LocalDate.now()));
	}
	
	public List<User> findAll(){
		return users;
	}
	public User findById(int id) {
		Predicate<? super User> predicate = user -> user.getId()==id;
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	public User save(User user) {
		user.setId(++count);
		users.add(user);
		return user;
	}
	public void deleteById(Integer id) {
		Predicate<? super User> predicate = user -> user.getId()==id;
		users.removeIf(predicate);
	}
}
