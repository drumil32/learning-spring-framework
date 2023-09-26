package com.learning.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyMathTest {
	MyMath math = new MyMath();

	@Test
	void calculateSum_ThreeMemberArray() {
		assertEquals(6,math.calculateSum(new int[] {1,2,3}),
				"method calculateSum_ThreeMemberArray :- expected sum of {1,2,3} is 6");
	}

	@Test
	void calculateSum_ZeroLengthArray() {
		assertEquals(2,math.calculateSum(new int[] {}),
				"method calculateSum_ZeroLengthArray :- expected sum of empty array is 0");
	}
}
