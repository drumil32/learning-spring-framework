package com.learn.springframework01.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name,int age,Address address) {}

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
		return new Person("Drumil Akhenia",21, new Address("hard","code"));
	}
	
	@Bean
//	implementing auto wiring using metho call [here we are calling method (other bean method) to create this bean]
//	it means we are creating new beans using existing beans which is managed by spring framework
	public Person person2MethodCall() {
		return new Person(name(),age(),address());
	}
	
	@Bean
	public Person person3PassingParameter(String name,int age,Address address2) { // here Address will call primary bean always WHY?(is this right conclusion)
		return new Person(name,age,address2);
	}
	
	@Bean(name="address1")
	@Primary
	public Address address() {
		return new Address("Station Road","Dhoraji");
	}
	
	@Bean(name="address2")
	@Qualifier("address2Qualifier")
	public Address address2() {
		return new Address("Address2","2");
	}
}
