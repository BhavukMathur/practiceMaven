package target2024.arraysstrings;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
public class LongestNonRepeatingSubstring {
	public static void main(String[] args) {
		String s = "abcabcbb";
		LongestNonRepeatingSubstring sub = new LongestNonRepeatingSubstring();
		System.out.println(sub.lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int maxLenSoFar = 1;
		Set<Character> hash = new HashSet<>();
		int i=0, j=0;
		char ch;

		while((i<=j) && (j<s.length())) {
			ch = s.charAt(j);
			if(hash.contains(ch)) {
				maxLenSoFar = Math.max(maxLenSoFar, (j-i));
				while(s.charAt(i) != ch) {
					hash.remove(s.charAt(i));
					i++;
				}
				i++;
				j++;
				if(j == s.length())
					break;
			} else {
				hash.add(ch);
				j++;
				if(j == s.length())
					break;
			}
		}
		return Math.max(maxLenSoFar, hash.size());
	}
}
