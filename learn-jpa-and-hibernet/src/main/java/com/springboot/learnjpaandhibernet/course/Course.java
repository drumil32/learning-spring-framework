package com.springboot.learnjpaandhibernet.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="Course")
public class Course {
	@Id
	@Column(name="id")
	private long id;
//	NOTE:- if data member name is same as column name then no need to use @Column annotation
//	THIS is also applied for name which we gave with @Entity THOUGH @Entity is required over there
	@Column(name="name")
	private String name;
	
	@Column(name="author")
	private String author;

	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public Course() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
