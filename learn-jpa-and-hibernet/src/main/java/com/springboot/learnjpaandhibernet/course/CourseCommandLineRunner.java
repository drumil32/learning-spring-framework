package com.springboot.learnjpaandhibernet.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.learnjpaandhibernet.course.jdbc.CourseJdbcRepository;
import com.springboot.learnjpaandhibernet.course.jpa.CourseJpaRepository;
import com.springboot.learnjpaandhibernet.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS", "Drumil AKHENIA"));
		repository.save(new Course(2, "Learn Docker", "Drumil Akhenia"));
		repository.save(new Course(3, "Learn K8s", "DRUMIL Akhenia"));
		repository.deleteById(1l);
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("Drumil Akhenia"));
		System.out.println(repository.findByName("Learn Docker"));
	}

}
