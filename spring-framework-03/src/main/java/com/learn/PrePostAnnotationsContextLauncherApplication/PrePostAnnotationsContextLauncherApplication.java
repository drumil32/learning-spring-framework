package com.learn.PrePostAnnotationsContextLauncherApplication;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
class SomeClass{
	private SomeDependency someDependency;
	public SomeClass(SomeDependency someDependency) {
		this.someDependency = someDependency;
		System.out.println("dependency are ready");
	}
	
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
}

@Component
class SomeDependency{

	public void getReady() {
		System.out.println("ok get ready is invoked");
	}
	@PostConstruct
	public void initialize1() {
		System.out.println("sd is ");
	}
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
	public static void main(String args[]) {
		try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(bean->System.out.println(bean));
			
		}
		
	}
}
