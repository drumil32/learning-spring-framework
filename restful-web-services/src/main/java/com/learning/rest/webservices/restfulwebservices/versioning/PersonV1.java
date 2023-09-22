package com.learning.rest.webservices.restfulwebservices.versioning;

public class PersonV1 {
	private String name;

	public PersonV1(String name) {
		super();
		this.name = name;
	}

	public static PersonV1 getObj() {
		return new PersonV1("Drumil Akhenia");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}

}
