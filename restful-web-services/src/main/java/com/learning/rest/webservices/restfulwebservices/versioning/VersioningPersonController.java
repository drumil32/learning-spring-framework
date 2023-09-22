package com.learning.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	PersonDaoService service;
	
	public VersioningPersonController(PersonDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/v1/person")
	public PersonV1 getPersonDetailsV1() {
		return service.getPersonV1() ;
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getPersonDetailsV2() {
		return service.getPersonV2();
	}
}
