package com.learn.springframework01.helloWorld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
//		1. Launch a Spring Context
//		2. Configure the things that we want Spring to manage - @Configuration 
		var context = new AnnotationConfigApplicationContext(HelloWorldSpringConfiguration.class);
		
//		3. retriving bean managed by spring
//			there are two ways for this
//				1. using name of method
//				2. using class
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("address1"));
//		System.out.println(context.getBean(Address.class)); 
//		if there is two bean methods which are returning Address then it will throw exception 
//		inorder to solve this we can use @primary 
		System.out.println(context.getBean("address2"));
		System.out.println(context.getBean("person2MethodCall"));
		System.out.println(context.getBean("person3PassingParameter"));
		
		Arrays.stream(context.getBeanDefinitionNames()).forEach(bean->System.out.println(bean));
		
		System.out.println(context.getBean("address2"));
		
		System.out.println(context.getBean("address2Qualifier",Address.class));
	}

}
