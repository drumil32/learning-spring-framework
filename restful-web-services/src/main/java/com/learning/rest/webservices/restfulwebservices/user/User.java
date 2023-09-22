package com.learning.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "name must have atleast 2 charecters")
	private String name;

	@Past(message = "birthdate should be in the past")
	@JsonProperty("birth_date") // if we want to change name of field in side json formate
	private LocalDate birthDate;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> post;

	public User(Integer id, @Size(min = 2, message = "name must have atleast 2 charecters") String name,
			@Past(message = "birthdate should be in the past") LocalDate birthDate, List<Post> post) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.post = post;
	}

	public User() {
	}

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

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", post=" + post + "]";
	}
}
