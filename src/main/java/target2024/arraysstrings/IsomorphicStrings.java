package target2024.arraysstrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150
public class IsomorphicStrings {
	public static void main(String[] args) {
		String s = "foo";
		String t = "bar";
		IsomorphicStrings is = new IsomorphicStrings();
		System.out.println(is.isIsomorphic(s, t));
	}

	public boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length())
			return false;

		//Construct map
		Map<Character, Character> hash = new HashMap<>();
		Set<Character> charTaken = new HashSet<>();
		char chs, cht;
		for(int i=0; i<s.length(); i++) {
			chs = s.charAt(i);
			cht = t.charAt(i);

			if(hash.get(chs) == null && charTaken.contains(cht)) {
				return false;
			} else if (hash.get(chs) == null && !charTaken.contains(cht)) {
				hash.put(chs, cht);
				charTaken.add(cht);
			} else if (hash.get(chs) != null) {
				if(hash.get(chs) != cht) {
					return false;
				}
			}
		}
		return true;
	}

}
