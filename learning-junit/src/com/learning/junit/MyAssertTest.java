package com.learning.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {
	List<String> arr = Arrays.asList("aws","docker","k8s","gcp");
			
	@Test
	void test() {
		boolean test = arr.contains("docker");
		assertEquals(true,test,"method test :- docker must be there is arr ");
		assertTrue(test,"method test :- docker must be there is arr ");
		assertFalse(arr.contains("azure"),"method test :- azure must not be there is arr ");
		assertEquals(4,arr.size(),"method test :- arr length is 4 ");
	}

}
