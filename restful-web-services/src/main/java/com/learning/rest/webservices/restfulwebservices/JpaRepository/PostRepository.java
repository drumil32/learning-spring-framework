package com.learning.rest.webservices.restfulwebservices.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.rest.webservices.restfulwebservices.user.Post;
import com.learning.rest.webservices.restfulwebservices.user.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	public List<Post> findByUser(User user);
    // You can add custom query methods here if needed
}