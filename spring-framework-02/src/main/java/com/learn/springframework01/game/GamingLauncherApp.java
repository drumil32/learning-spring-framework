package com.learn.springframework01.game;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learn.springframework01.game")
public class GamingLauncherApp {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(GamingLauncherApp.class);
		Arrays.stream(context.getBeanDefinitionNames()).forEach(bean->System.out.println(bean));
		
		GameRunner gameRunner = (GameRunner) context.getBean("gameRunner");
		gameRunner.run();
	}

}
