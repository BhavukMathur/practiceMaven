package target2024.arraysstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> hash = new HashMap<>();
		List<List<String>> ansList = new ArrayList<>();

		String temp;
		char[] chArr;
		for(String str: strs) {

			chArr = str.toCharArray();
			Arrays.sort(chArr);
			temp = new String(chArr);

			//New anagram family
			if(hash.get(temp) == null) {
				List<String> strList = new ArrayList();
				strList.add(str);
				hash.put(temp, strList);
			} else {
				List<String> strList = hash.get(temp);
				strList.add(str);
				hash.put(temp, strList);
			}
		}

		hash.forEach((k, v) -> {
			ansList.add(v);
		});

		return ansList;
	}
}

public class GroupAnagramsTogether {
	public static void main(String[] args) {
		Solution ss = new Solution();
		String[] strList = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> groupAnagramList = ss.groupAnagrams(strList);

		groupAnagramList.forEach(strs -> {
			strs.forEach(str -> {
				System.out.print(str + " | ");
			});
			System.out.println();
		});
	}
}
