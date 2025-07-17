package target2024.slidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0, right = 0;

        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abcbabcbb";
        int result = lengthOfLongestSubstring(input);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}
