package target2024.stackQueue;

import java.util.Stack;

public class Calculator {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		String str = "3+2*2";
		System.out.println(cal.calculate(str));
	}

	public int calculate(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}

		int len = s.length();
		Stack<Integer> stack = new Stack<>();

		int num = 0;
		char sign = '+';

		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				num = num * 10 + ch - '0';
			}
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = ch;
				num = 0;
			}
		}

		int result = 0;
		for (int i : stack) {
			result += i;
		}
		return result;
	}
}
