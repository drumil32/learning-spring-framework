package com.learn.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username,String password) {
		boolean isValidUserName = username.equalsIgnoreCase("drumil");
		boolean isValidPassword = password.equalsIgnoreCase("drumil");
		
		return isValidUserName && isValidPassword;
	}
}
