package com.learn.XmlConfigurationContextLauncherApplication;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;


public class XmlConfigurationContextLauncherApplication {
	public static void main(String args[]) {
		try(var context = new ClassPathXmlApplicationContext( "contextConfiguration.xml" ) ){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(bean->System.out.println(bean));
			System.out.println( context.getBean("name") );
		}
		
	}
}
