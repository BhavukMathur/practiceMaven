package target2024.arraysstrings;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/description/?envType=company&envId=coupang&favoriteSlug=coupang-all
public class DecodeString {

	public static void main(String[] args) {

	}

	public String decodeString(String s) {
		Stack<Integer> counts = new Stack<>();
		Stack<String> resultStack = new Stack<>();
		String result = "";
		int index = 0;

		while (index < s.length()) {
			if (Character.isDigit(s.charAt(index))) {
				int start = index;
				while (Character.isDigit(s.charAt(index + 1))) {
					index++;
				}
				int count = Integer.parseInt(s.substring(start, index + 1));
				counts.push(count);
			} else if (s.charAt(index) == '[') {
				resultStack.push(result);
				result = "";
			} else if (s.charAt(index) == ']') {
				StringBuilder temp = new StringBuilder(resultStack.pop());
				int repeatTimes = counts.pop();
				for (int i = 0; i < repeatTimes; i++) {
					temp.append(result);
				}
				result = temp.toString();
			} else {
				result += s.charAt(index);
			}
			index++;
		}

		return result;
	}
}
