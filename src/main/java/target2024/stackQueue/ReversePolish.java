package target2024.stackQueue;

import java.util.Stack;

public class ReversePolish {
	public static void main(String[] args) {
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {
		int result = 0;
		Stack<String> stack = new Stack<>();

		int a, b;
		for(String str: tokens) {
			switch (str) {
				case "+":
					b = Integer.valueOf(stack.pop());
					a = Integer.valueOf(stack.pop());
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					b = Integer.valueOf(stack.pop());
					a = Integer.valueOf(stack.pop());
					stack.push(String.valueOf(a - b));
					break;
				case "/":
					b = Integer.valueOf(stack.pop());
					a = Integer.valueOf(stack.pop());
					stack.push(String.valueOf(a / b));
					break;
				case "*":
					b = Integer.valueOf(stack.pop());
					a = Integer.valueOf(stack.pop());
					stack.push(String.valueOf(a * b));
					break;
				default:
					stack.push(str);
					break;
			}
		}
		return Integer.valueOf(stack.pop());
	}

}
