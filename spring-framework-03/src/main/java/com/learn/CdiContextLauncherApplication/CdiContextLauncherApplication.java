package com.learn.CdiContextLauncherApplication;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
class BusinessService{
	private DataService dataService;
	
	public DataService getDataService() {
		return dataService;
	}
	
	@Autowired
	public void setDataService() {
		this.dataService = new DataService();
	}
}

@Component
class DataService{
	
}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
	public static void main(String args[]) {
		try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(bean->System.out.println(bean));
			
		}
		
	}
}
