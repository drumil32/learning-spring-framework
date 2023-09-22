package com.learning.rest.webservices.restfulwebservices.helloworld.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2,message="name must have atleast 2 charecters")
	private String name;
	
	@Past(message="birthdate should be in the past")
	@JsonProperty("birth_date") // if we want to change name of field in side json formate
	private LocalDate birthDate;

	public User(int id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.birthDate = birthDate;
		this.name = name;
	}
	public User() {}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", birthDate=" + birthDate + ", name=" + name + "]";
	}

}
