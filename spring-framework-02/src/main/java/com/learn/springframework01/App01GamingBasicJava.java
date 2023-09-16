package com.learn.springframework01;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learn.springframework01.game.GameConsole;
import com.learn.springframework01.game.GameRunner;
import com.learn.springframework01.game.PacManGame;

@Configuration
public class App01GamingBasicJava {
	@Bean
	public GameRunner gameRunner(GameConsole gameConsole) {
		return new GameRunner(gameConsole);
	}
	
	@Bean 
	public GameConsole gameConsole(){
		return new PacManGame();
	}
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(App01GamingBasicJava.class);
		Arrays.stream(context.getBeanDefinitionNames()).forEach(bean->System.out.println(bean));
		
		GameRunner gameRunner = (GameRunner) context.getBean("gameRunner");
		gameRunner.run();
	}

}
