package com.springboot.learnjpaandhibernet.course.jpa;

import org.springframework.stereotype.Repository;

import com.springboot.learnjpaandhibernet.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Course course) {
		entityManager.merge(course);
	}
	public void delete(long courseId) {
		Course course = entityManager.find(Course.class,courseId);
		entityManager.remove(course);
	}
	public Course findById(long courseId) {
		return entityManager.find(Course.class,courseId);
	}
	
}
