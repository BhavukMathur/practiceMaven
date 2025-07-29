package target2024.arraysstrings;

import java.util.*;

public class WordWrap {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("Hello", "Sir", "Please", "Upvote", "If", "You", "Like", "My", "Post");
        int maxLen = 10;

        List<String> output = wrapWords(input, maxLen);
        for (String line : output) {
            System.out.println(line);
        }
    }
    
    private static List<String> wrapWords(List<String> input, int maxLen) {
    	List<String> result = new LinkedList<>();
    	StringBuilder sb = new StringBuilder();
    	
    	int len;
    	for(String word: input) {
    		len = word.length();
    		if(sb.isEmpty()) {
    			sb.append(word);
    		} else if(sb.length() + len < maxLen) {
    			sb.append("-").append(word);
    		} else {
    			result.add(sb.toString());
    			sb = new StringBuilder();
    			sb.append(word);
    		}
    	}
    	result.add(sb.toString());
    	return result;
    }
}
