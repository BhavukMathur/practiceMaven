package target2024.algorithms;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
public class RansomNote {
	public static void main(String[] args) {
		RansomNote rs = new RansomNote();
		String magazine = "aabasdfaabccd";
		String ransomNote = "aabe";
		System.out.println(rs.canConstruct(ransomNote, magazine));
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		//Construct magazine hashmap
		Map<Character, Integer> mhash = new HashMap();
		for(Character ch: magazine.toCharArray()) {
			if(mhash.get(ch) == null) {
				mhash.put(ch, 1);
			} else {
				mhash.put(ch, mhash.get(ch) + 1);
			}
		}

		for(Character ch: ransomNote.toCharArray()) {
			if(mhash.get(ch) == null || mhash.get(ch) == 0) {
				return false;
			} else {
				mhash.put(ch, mhash.get(ch) - 1);
			}
		}
		return true;
	}

}
