package com.learning.rest.webservices.restfulwebservices.helloworld.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // You can add custom query methods here if needed
}
