package com.learn.springframework01.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GameConsole{
	public void up() {
		System.out.println("Super contra is moving up");
	}
	public void left() {
		System.out.println("Super contra is moving left");
	}
	public void right() {
		System.out.println("super Contrais moving right");
	}
	public void down() {
		System.out.println("super Contrais moving down");
	}
}
