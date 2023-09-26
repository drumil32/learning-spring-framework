package com.learning.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class MyBeforeAfterTest {

	/*
	 * NOTE:- order or execution of these test cases is not garrunted it might be
	 * different. so if we want to do some task (memory clean up or db clean up)
	 * then we can use annotation like beforeEach and afterEach
	 */
	@BeforeEach
	void loggingBeforEachTest() {
		System.out.println("before each test");
	}

	@AfterEach
	void loggingAfterEachTest() {
		System.out.println("after each test");
	}

	@BeforeAll
	static void loggingBeforeAllTest() {
		System.out.println("befor all test");
	}

	@AfterAll
	static void loggingAfterAllTest() {
		System.out.println("after all test");
	}

	@Test
	void test1() {
		System.out.println("test1");
	}

	@Test
	void test2() {
		System.out.println("test2");
	}

	@Test
	void test3() {
		System.out.println("test3");
	}
}
