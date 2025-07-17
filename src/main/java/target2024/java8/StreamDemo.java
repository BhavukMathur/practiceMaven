package target2024.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamDemo {
	public static void main(String[] args) {
		//Streams
		List<String> players = Arrays.asList("Sachin", "Kallis", "Ponting");
		List<String> players2 = players.stream()
				.filter(name -> !name.contains("o"))
				.collect(Collectors.toList());
		System.out.println(players2);

		//Getting the second-highest element from a list using streams
		List<Integer> intList = Arrays.asList(5, 2, 3, 0, 4, 1);

		Optional<Integer> secondHighest = intList.stream()
				.sorted(Comparator.reverseOrder()) // sorting in descending order
				.skip(1) // skip the first element
				.findFirst(); // get the second-highest element
		System.out.println("Second highest = " + secondHighest.get());
	}
}
