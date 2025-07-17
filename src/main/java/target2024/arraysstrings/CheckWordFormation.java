package target2024.arraysstrings;

import java.util.HashMap;
import java.util.Map;

public class CheckWordFormation {
	public static void main(String[] args) {
		String[] words = {"baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"};
		// String[] words = {"cat"};
		String note1 = "ctay";
		String note2 = "bcanihjsrrrferet";
		String note3 = "tbaykkjlga";
		String note4 = "bbbblkkjbaby";
		String note5 = "dad";
		String note6 = "breadmaking";
		String note7 = "dadaa";
		System.out.println(find(words, note1));
		System.out.println(find(words, note2));
		System.out.println(find(words, note3));
		System.out.println(find(words, note4));
		System.out.println(find(words, note5));
		System.out.println(find(words, note6));
		System.out.println(find(words, note7));
	}

	private static String find(String[] words, String note) {
		Map<Character, Integer> charMap = new HashMap<>();
		Map<Character, Integer> bkMap = new HashMap<>();

		//[c:1, t:1 ..]

		char ch;
		for(int i=0; i< note.length(); i++) {
			ch = note.charAt(i);
			if(charMap.get(ch) == null) {
				charMap.put(ch, 1);
				bkMap.put(ch, 1);
			} else {
				charMap.put(ch, charMap.get(ch) + 1);
				bkMap.put(ch, bkMap.get(ch) + 1);
			}
		}

		// System.out.println(charMap);

		//{"baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"};
		int i = 0;
		for(String str: words) {
			charMap.putAll(bkMap);
			// System.out.println(str + " " + charMap);
			for(i=0; i < str.length(); i++) {
				ch = str.charAt(i);
				if(charMap.get(ch) == null || charMap.get(ch) == 0) {
					//char not found
					break;
				} else {
					charMap.put(ch, charMap.get(ch) - 1);
				}
			}
			if(i == str.length()) {
				//Iteration successful
				return str;
			}
		}
		return "-";
	}
}
