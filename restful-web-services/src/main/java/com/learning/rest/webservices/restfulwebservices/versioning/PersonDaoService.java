package com.learning.rest.webservices.restfulwebservices.versioning;

import org.springframework.stereotype.Component;

@Component
public class PersonDaoService {
	private static PersonV1 personv1 = new PersonV1("Drumil Akhenia");
	private static PersonV2 personv2 = new PersonV2(new Name("Drumil","Akhenia"));
	
	public PersonV1 getPersonV1() {
		return personv1;
	}
	
	public PersonV2 getPersonV2() {
		return personv2;
	}
}
