package target2024.arraysstrings;

import java.util.HashSet;
import java.util.Set;

//https://www.metacareers.com/profile/coding_practice_question/?problem_id=2237975393164055&c=1373057600385980&psid=275492097255885&practice_plan=0&b=0111122
//Use a hashMap instead of hashSet for count
public class MinimumLengthSubstring {
	public static void main(String[] args) {
		MinimumLengthSubstring mls = new MinimumLengthSubstring();
		//Reversed
		System.out.println(mls.minLengthSubstring("dxdcbefebce", "fd"));
	}

	int minLengthSubstring(String s, String t) {
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;

		//Prepare a hashset from target string
		Set<Character> hashSet = new HashSet<>();
		for(int i=0; i<t.length(); i++) {
			hashSet.add(t.charAt(i));
		}

		//Check for the extreme indexes
		char ch;
		for(int i=0; i<s.length(); i++) {
			ch = s.charAt(i);
			if(hashSet.contains(ch)) {
				if(i < start) {
					start = i;
				}
				if(i > end) {
					end = i;
				}
			}
		}
		return (end - start + 1);
	}
}
