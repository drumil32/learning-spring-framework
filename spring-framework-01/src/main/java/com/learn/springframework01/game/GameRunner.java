package com.learn.springframework01.game;

public class GameRunner {
	private MarioGame marioGame;
	public GameRunner(MarioGame marioGame){
		this.marioGame = marioGame;
	}
	public void run() {
		System.out.println("Running game : " + marioGame);
		marioGame.up();
		marioGame.down();
		marioGame.left();
		marioGame.right();
	}
}
