package functional_programming_with_java.programming;

import java.util.List;

public class FP01Functional {

	private static void print(int number) {
		System.out.println(number);
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1,2,3,4,7,6,23,11);
		printAllNumbersInListStructure(numbers);
		printEvenNumbersInListStructure(numbers);
		printAllNumbersInListStructureLambda(numbers);
		printEvenNumbersInListStructureLambda(numbers);
	}

	private static boolean isEven(int val) {
		return 0==val%2;
	}
	
	private static void printEvenNumbersInListStructure(List<Integer> numbers) {
		numbers.stream()
			.filter(FP01Functional::isEven)
			.forEach(System.out::println);
	}
	private static void printAllNumbersInListStructureLambda(List<Integer> numbers) {
		numbers.forEach(i->System.out.println(i));
	}
	private static void printEvenNumbersInListStructureLambda(List<Integer> numbers) {
		numbers.forEach(i->{
			if( 0==i%2 )
				System.out.println(i);
		});
		numbers.stream()
			.filter(i->0==i%2)
			.forEach(i->System.out.println(i));
	}
	private static void printAllNumbersInListStructure(List<Integer> numbers) {
//		numbers.stream().forEach(FP01Functional::print);
		numbers.stream().forEach(System.out::println);
		numbers.forEach(System.out::println);
	}
}