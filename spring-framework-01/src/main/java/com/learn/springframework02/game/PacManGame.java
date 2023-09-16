package com.learn.springframework02.game;

public class PacManGame implements GameConsole {

	@Override
	public void up() {
		System.out.println("Pacman is moving up");

	}

	@Override
	public void down() {
		System.out.println("Pacman is moving down");
	}

	@Override
	public void left() {
		System.out.println("Pacman is moving left");
	}

	@Override
	public void right() {
		System.out.println("Pacman is moving right");
	}

}
