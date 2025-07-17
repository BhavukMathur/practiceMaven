package target2024.arraysstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagramsInString {
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(findAnagrams(s, p));
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> matchingIndexes = new ArrayList<>();

		Map<Character, Integer> hash = new HashMap<>();
		Map<Character, Integer> slidingHash = new HashMap<>();
		buildHash(hash, p);

		//Sliding window
		buildHash(slidingHash, s.substring(0, p.length()));
//		System.out.println(slidingHash);
		compareHashes(hash, slidingHash, 0, matchingIndexes);

		for(int i=1; (i + p.length() - 1) <s.length(); i++) {
			Character toRemove = s.charAt(i - 1);
			Character toAdd = s.charAt(i + p.length() - 1);

			if((slidingHash.get(toRemove) - 1) == 0) {
				slidingHash.remove(toRemove);
			} else {
				slidingHash.put(toRemove, slidingHash.get(toRemove) - 1);
			}
			slidingHash.put(toAdd, slidingHash.get(toAdd) == null ? 1 : slidingHash.get(toAdd) + 1);
//			System.out.println(slidingHash);
			compareHashes(hash, slidingHash, i, matchingIndexes);
		}
		return(matchingIndexes);
	}

	private static void compareHashes(Map<Character, Integer> hash,
									  Map<Character, Integer> slidingHash,
									  int ind,
									  List<Integer> matchingIndexes) {
		if(hash.equals(slidingHash)) {
			matchingIndexes.add(ind);
		}
	}

	private static void buildHash(Map<Character, Integer> hash, String ptr) {
		for(int i=0; i<ptr.length(); i++) {
			char ch = ptr.charAt(i);
			if(hash.get(ch) == null) {
				hash.put(ch, 1);
			} else {
				hash.put(ch, hash.get(ch) + 1);
			}
		}
	}
}
