package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {
//	the IMP point with spring security is IF WE START DEFINING A SECURITY CHAIN WE NEED TO DEFINE ENTIRE CHAIN
//	BY default spring security authenticate all requests
//	basic authentication
	
//	disabling CSRF
//	we are creating rest apis
//	so we don't need state (stateless rest api)
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth
							.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
							.anyRequest().authenticated()
							.requestMatchers(PathRequest.toH2Console()).permitAll() 
				);
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(
				session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.csrf().disable();
		return http.build();
	}
}
