package functional_programming_with_java.programming;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1,2,3,4,7,6,23,11);
		printAllNumbersInListStructure(numbers);

		printEvenNumbersInListStructure(numbers);
	}
	
	private static void printEvenNumbersInListStructure(List<Integer> numbers) {
		for(Integer number: numbers) {
			if( 0==number%2 ) {
				System.out.println(number);
			}
		}
	}

	private static void printAllNumbersInListStructure(List<Integer> numbers) {
		for(Integer number : numbers) {
			System.out.println(number);
		}
	}
}