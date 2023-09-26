package com.learning.mockito.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTestV2 {

	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	SomeBusinessImpl businessImpl;
	
	
	@Test
	void findGreatestFromAllData_basicTest() {
		when(dataServiceMock.retriveAllData()).thenReturn(new int [] {1,2,9,1,89,23});
		assertEquals(89, businessImpl.findGreatestFromAllData());
	}

	@Test
	void findGreatestFromAllData_oneValue() {
		when(dataServiceMock.retriveAllData()).thenReturn(new int [] {9});
		assertEquals(9, businessImpl.findGreatestFromAllData());
	}
}
