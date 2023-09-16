package com.learn.springframework01;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
class A{
	A(){
		System.out.println("ok A is done");
	}
	public void helper() {
		System.out.println("olu olu");
	}
}

@Component
//@Lazy
class B{
	private A a;
	B(A a){
		System.out.println("here we are");
		this.a = a;
	}
	public void doSomething() {
		System.out.println("we are here");
	}
}
@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
	public static void main(String args[]) {
		try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(bean->System.out.println(bean));
			System.out.println("we done");
			context.getBean(A.class).helper();
			context.getBean(B.class).doSomething();
		}
	}
}
