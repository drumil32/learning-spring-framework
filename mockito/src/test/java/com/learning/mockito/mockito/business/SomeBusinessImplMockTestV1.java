package com.learning.mockito.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class SomeBusinessImplMockTestV1 {

	@Test
	void findGreatestFromAllData_basicTest() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retriveAllData()).thenReturn(new int [] {1,2,9,1,89,23});
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int value = businessImpl.findGreatestFromAllData();
		assertEquals(89, value);
	}

	@Test
	void findGreatestFromAllData_oneValue() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retriveAllData()).thenReturn(new int [] {9});
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int value = businessImpl.findGreatestFromAllData();
		assertEquals(9, value);
	}
}
