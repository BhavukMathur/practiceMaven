package target2024.arraysstrings;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/description/
public class MinWindowSubstring {
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
//		System.out.println(minWindow(s, t));
		System.out.println(minWindowBrute(s, t));
	}

	public static String minWindowBrute(String s, String t) {
		String temp;
		for(int i=0; i<s.length(); i++) {
			for(int j=i; j<s.length(); j++) {
				temp = s.substring(i, j+1);
				//Compare the strings for frequency
			}
		}
		return "";
	}


		public static String minWindow(String s, String t) {
		if(s == null || t == null || s.isEmpty() || t.isEmpty()) {
			return "";
		}

		Map<Character, Integer> countByCharT = new HashMap<>();
		for(int i=0; i<t.length(); i++) {
			countByCharT.put(t.charAt(i), countByCharT.getOrDefault(t.charAt(i), 0) + 1);
		}
		//A:1, B:1, C:1

		Map<Character, Integer> countByCharSW = new HashMap<>();
		int left = 0, right = 0;
		int flen = Integer.MAX_VALUE, fLeft=0, fRight=0;

		char ch;
		int windowSize = 0;
		while(right < s.length()) {
			ch = s.charAt(right);
			countByCharSW.put(ch, countByCharSW.getOrDefault(ch, 0) + 1);

			if(countByCharT.containsKey(ch) && (countByCharSW.get(ch) == countByCharT.get(ch))) {
				windowSize++;
			}

			while(left <= right && windowSize == countByCharT.size()) {
				//Match found
				flen = right - left + 1;
				fLeft = left;
				fRight = right;

				//Slide left pointer
				char temp = s.charAt(left);
				countByCharSW.put(temp, countByCharSW.get(temp) - 1);
				//TODO :(
			}
		}
		return null;
	}
}
