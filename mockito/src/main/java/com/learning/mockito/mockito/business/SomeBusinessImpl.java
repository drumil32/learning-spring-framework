package com.learning.mockito.mockito.business;

public class SomeBusinessImpl {
	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		this.dataService = dataService;
	}

	public int findGreatestFromAllData() {
		int[] data = dataService.retriveAllData();
		int greatestValue = Integer.MIN_VALUE;
		for (int value : data) {
			greatestValue = Math.max(value, greatestValue);
		}
		return greatestValue;
	}
}

interface DataService {
	int[] retriveAllData();
}