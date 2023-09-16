package com.learn.springframework01.dependecyInjection;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class Business{
//	@Autowired
	Dependency1 dep1;
//	@Autowired
	Dependency2 dep2;

//	public Business(Dependency1 dep1,Dependency2 dep2) {
//		this.dep1 = dep1;
//		this.dep2 = dep2;
//	}
	
	@Autowired
	public void setDep1(Dependency1 dep1) {
		this.dep1 = dep1;
	}
	@Autowired
	public void setDep2(Dependency2 dep2) {
		this.dep2 = dep2;
	}
	public String toString() {
		return dep1 + " " + dep2;
	}
}
@Component
class Dependency1{
	
}
@Component
class Dependency2{
	
}

@Configuration
@ComponentScan
public class DepencyInjectionLauncherApp {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(DepencyInjectionLauncherApp.class);
		Arrays.stream(context.getBeanDefinitionNames()).forEach(bean-> System.out.println(bean));
		System.out.println(context.getBean(Dependency1.class));
		System.out.println(context.getBean(Dependency2.class));
		System.out.println(context.getBean(Business.class));
	}

}

























