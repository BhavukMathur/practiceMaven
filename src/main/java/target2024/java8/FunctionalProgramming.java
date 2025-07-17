package target2024.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> evenNumbersDoubled = numbers.stream()
				.filter(num -> num %2 == 0)
				.map(num -> num * 2)
				.collect(Collectors.toList());

		System.out.println(Arrays.asList(evenNumbersDoubled));
	}
}
