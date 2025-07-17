package target2024.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

	public static void main(String[] args) {
		List<List<String>> listOfLists = Arrays.asList(
				Arrays.asList("list11", "list12"),
				Arrays.asList("list21", "list22")
		);
		
		List<String> flatList = listOfLists.stream()
				.flatMap(List::stream)
				.collect(Collectors.toList());
		
		System.out.println(flatList);
	}

}
