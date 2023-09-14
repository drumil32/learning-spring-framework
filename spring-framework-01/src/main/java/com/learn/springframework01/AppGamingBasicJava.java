package com.learn.springframework01;

import com.learn.springframework01.game.GameRunner;
import com.learn.springframework01.game.MarioGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		var marioGame = new MarioGame();
		var gameRunner = new GameRunner(marioGame);
		gameRunner.run();
	}

}
