package com.springboot.learnjpaandhibernet.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.learnjpaandhibernet.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private CourseJdbcRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1,"Learn AWS","Drumil Akhenia"));
		repository.insert(new Course(2,"Learn Docker","Drumil Akhenia"));
		repository.insert(new Course(3,"Learn K8s","Drumil Akhenia"));
		repository.delete(1);
	}

}
