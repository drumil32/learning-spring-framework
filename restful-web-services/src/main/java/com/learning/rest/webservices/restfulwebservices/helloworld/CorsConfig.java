package com.learning.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000") // Allow requests from your React app
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(true); // If you need to support cookies or authentication
    }
}
