package target2024.stackQueue;

import java.util.Stack;

public class ValidParenthesis {
	public static void main(String[] args) {
		ValidParenthesis vp = new ValidParenthesis();
		String s = "({[]})[]{}[";
		System.out.println(vp.isValid(s));
	}

	public boolean isValid(String s) {
		if(s == null || s.isEmpty()) {
			return true;
		}
		Stack<Character> stack = new Stack<>();

		for(Character ch: s.toCharArray()) {
			if(ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else if (stack.isEmpty()) {
				return false;
			} else {
				if(ch == ')' && stack.peek() != '(') {
					return false;
				}
				else if(ch == '}' && stack.peek() != '{') {
					return false;
				}
				else if(ch == ']' && stack.peek() != '[') {
					return false;
				} else {
					stack.pop();
				}
			}
		}

		return stack.isEmpty();
	}

}
