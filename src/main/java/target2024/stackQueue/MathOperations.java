package target2024.stackQueue;

import java.util.Stack;

//Reverse Polish Notation
public class MathOperations {
	public static void main(String[] args) {
		MathOperations mo = new MathOperations();
		String[] tokens = {"4","13","5","/","+"};
		System.out.println(mo.evalRPN(tokens));
	}

	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<>();
		Integer left, right, result=0;
		for(String str: tokens) {
			if(str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*")) {
				right = Integer.valueOf(stack.pop());
				left = Integer.valueOf(stack.pop());
				switch (str) {
					case "+":
						result = left + right;
						break;
					case "-":
						result = left - right;
						break;
					case "/":
						result = left / right;
						break;
					case "*":
						result = left * right;
						break;
				}
				stack.push(result.toString());
			} else {
				stack.push(str);
			}
		}
		return Integer.valueOf(stack.peek());
	}
}
