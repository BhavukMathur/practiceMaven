package target2024.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsTogether {
	public static void main(String[] args) {
		String[] strList = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> result = group(strList);

		result.forEach(list -> {
			list.forEach(val -> {
				System.out.print(val + " ");
			});
			System.out.println();
		});
	}

	private static List<List<String>> group(String[] strs) {
		if(strs == null || strs.length == 0) {
			return new ArrayList<>();
		}

		Map<String, List<String>> group = new HashMap<>();

		Arrays.stream(strs).forEach(str -> {
			char[] chArr = str.toCharArray();
			Arrays.sort(chArr);
			String sortedKey = String.valueOf(chArr);
			group.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(str);
		});

		return new ArrayList<>(group.values());
	}
}
