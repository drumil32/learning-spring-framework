package com.learning.mockito.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

	@Test
	void findGreatestFromAllData_basicTest() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStubBasic());
		int value = businessImpl.findGreatestFromAllData();
		assertEquals(12,value);
	}

	@Test
	void findGreatestFromAllData_oneValueTest() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStubOneValue());
		int value = businessImpl.findGreatestFromAllData();
		assertEquals(90,value);
	}
}

class DataServiceStubBasic implements DataService{

	@Override
	public int[] retriveAllData() {
		return new int[] {1,2,1,12,11,10};
	}
	
}
class DataServiceStubOneValue implements DataService{

	@Override
	public int[] retriveAllData() {
		return new int[] {90};
	}
	
}