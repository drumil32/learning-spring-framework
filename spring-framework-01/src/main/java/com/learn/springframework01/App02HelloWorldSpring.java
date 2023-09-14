package com.learn.springframework01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
//		1. Launch a Spring Context
//		2. Configure the things that we want Spring to manage - @Configuration 
		var context = new AnnotationConfigApplicationContext(HelloWorldSpringConfiguration.class);
		
//		3. retriving bean managed by spring
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("address"));
	}

}
