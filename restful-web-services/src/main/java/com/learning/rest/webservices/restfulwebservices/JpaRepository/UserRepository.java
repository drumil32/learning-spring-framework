package com.learning.rest.webservices.restfulwebservices.JpaRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.rest.webservices.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
    // You can add custom query methods here if needed
}
