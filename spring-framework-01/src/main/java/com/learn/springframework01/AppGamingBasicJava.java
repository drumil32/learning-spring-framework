package com.learn.springframework01;

import com.learn.springframework01.game.GameConsole;
import com.learn.springframework01.game.GameRunner;
import com.learn.springframework01.game.MarioGame;
import com.learn.springframework01.game.PacManGame;
import com.learn.springframework01.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		GameConsole game = new MarioGame();
		GameRunner gameRunner = new GameRunner(game);
		gameRunner.run();
		game = new SuperContraGame();
		gameRunner.setConsole(game);
		gameRunner.run();
		game = new PacManGame();
		gameRunner.setConsole(game);
		gameRunner.run();
	}

}
