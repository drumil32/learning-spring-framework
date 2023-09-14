package com.learn.springframework01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name,int age) {}

record Address(String firstLine,String city) {}

@Configuration
public class HelloWorldSpringConfiguration {
	@Bean // Indicates that a method produces a bean to be managed by the Spring container. 
	public String name() {
		return "Drumil";
	}
	
	@Bean
	public int age() {
		return 21;
	}
	
	@Bean
	public Person person() {
		return new Person("Drumil Akhenia",21);
	}
	
	@Bean
	public Address address() {
		return new Address("Station Road","Dhoraji");
	}
}
