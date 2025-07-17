package target2024.arraysstrings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		Map<Character, Integer> hash = new HashMap<>();
		Integer[] indArr = new Integer[26];

		for(int i=0; i<indArr.length; i++) {
			indArr[i] = -1;
		}

		char ch;
		Integer count;
		for(int i=0; i<str.length(); i++) {
			ch = str.charAt(i);
			count = hash.get(ch);
			if (count == null) {
				hash.put(ch, 1);
				indArr[ch - 'a'] = i;
			} else {
				hash.put(ch, -1);
				indArr[ch - 'a'] = -1;
			}
		}

		int firstInd = Integer.MAX_VALUE;
		for(int i=0; i<indArr.length; i++) {
			if((indArr[i] != -1) && indArr[i] < firstInd) {
				firstInd = i;
			}
		}

		System.out.println(str.charAt(firstInd));

	}
}
