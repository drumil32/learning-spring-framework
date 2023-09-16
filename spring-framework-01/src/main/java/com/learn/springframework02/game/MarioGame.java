package com.learn.springframework02.game;

public class MarioGame implements GameConsole{
	public void up() {
		System.out.println("mario is moving up");
	}
	public void left() {
		System.out.println("mario is moving left");
	}
	public void right() {
		System.out.println("mario is moving right");
	}
	public void down() {
		System.out.println("mario is moving down");
	}
}