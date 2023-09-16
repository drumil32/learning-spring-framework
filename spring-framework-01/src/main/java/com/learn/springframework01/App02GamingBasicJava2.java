package com.learn.springframework01;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.learn.springframework02.game.GameRunner;

public class App02GamingBasicJava2 {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(App02GamingConfiguration.class);
		Arrays.stream(context.getBeanDefinitionNames()).forEach(bean->System.out.println(bean));
		
		GameRunner gameRunner = (GameRunner) context.getBean("gameRunner");
		gameRunner.run();
	}

}
