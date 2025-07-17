package target2024.arraysstrings;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/word-break/?envType=study-plan-v2&envId=top-interview-150
public class WordBreak {
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		List<String> wordDict = Arrays.asList("apple","pen");
		System.out.println(wb.wordBreakRecursion(wordDict, "applepenapple"));
	}
	boolean wordBreakRecursion(List<String> wordList, String word) {
		if (word.isEmpty()) {
			return true;
		}
		int wordLen = word.length();
		for (int i = 1; i <= wordLen; ++i) {
			String prefix = word.substring(0, i);
			if (wordList.contains(prefix)
					&& wordBreakRecursion(wordList, word.substring(i))) {
				return true;
			}
		}
		return false;
	}
}
