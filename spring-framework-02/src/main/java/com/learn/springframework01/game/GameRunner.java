package com.learn.springframework01.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	private GameConsole game;
	public GameRunner(@Qualifier("SuperContraGameQualifier")GameConsole game){
		this.game = game;
	}
	public void run() {
		System.out.println("Running game : " + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
	public void setConsole(GameConsole game) {
		this.game = game;
		
	}
}
