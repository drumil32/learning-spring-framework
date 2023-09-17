package functional_programming_with_java.programming;

import java.util.List;

public class FP01Exercise {
	public static void main(String []args) {
		List<Integer> numbers = List.of(1,2,3,4,7,6,23,11);
//		printAllOddNumbers(numbers);
		printCubeOfAllOddNumbers(numbers);
		List<String> courses = List.of("Spring","Spring Boot","API","Microserivce","AWS","PCF","Azure","Docker","Kubernetes");
//		printAllStrings(courses);
//		printAllStringsWhichHaveSpring(courses);
//		printAllStringsWhichHaveLenMoreThanEqualTo4(courses);
//		printNumberOfCharsInEachString(courses);
		printNumberOfCharsInEachStringWithString(courses);
	}

	private static void printNumberOfCharsInEachStringWithString(List<String> courses) {
		courses.stream()
			.map(course-> course + " " + course.length())
			.forEach(System.out::println);
	}

	private static void printNumberOfCharsInEachString(List<String> courses) {
		courses.stream()
			.map(course->course.length())
			.forEach(System.out::println);
	}

	private static void printCubeOfAllOddNumbers(List<Integer> numbers) {
		numbers.stream()
			.map(number -> number*number*number)
			.forEach(System.out::println);
	}

	private static void printAllStringsWhichHaveLenMoreThanEqualTo4(List<String> courses) {
		courses.stream().filter(course->course.length()>=4).forEach(System.out::println);
	}

	private static void printAllStringsWhichHaveSpring(List<String> courses) {
		courses.stream().filter(course->course.contains("Spring")).forEach(System.out::println);
	}

	private static void printAllStrings(List<String> courses) {
		courses.forEach(System.out::println);
	}

	private static void printAllOddNumbers(List<Integer> numbers) {
		numbers.stream().filter(i-> 1==(i&1) ).forEach(i->System.out.print(i+" "));
	}
}
