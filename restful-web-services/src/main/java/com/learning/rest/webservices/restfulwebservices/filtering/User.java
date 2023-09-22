package com.learning.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"emailId","id"}) // class level static filtering
public class User {
	private String username;
	
	@JsonIgnore // filed level static filtering
	private String password;
	private int id;
	private String emailId;
	public User(String username, String password, int id, String emailId) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.emailId = emailId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + ", emailId=" + emailId + "]";
	}
}
