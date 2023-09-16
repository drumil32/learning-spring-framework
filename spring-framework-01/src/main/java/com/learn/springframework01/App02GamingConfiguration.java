package com.learn.springframework01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learn.springframework02.game.GameConsole;
import com.learn.springframework02.game.PacManGame;
import com.learn.springframework02.game.GameRunner;

@Configuration
public class App02GamingConfiguration {
	@Bean
	public GameRunner gameRunner(GameConsole gameConsole) {
		return new GameRunner(gameConsole);
	}
	
	@Bean 
	public GameConsole gameConsole(){
		return new PacManGame();
	}
}
