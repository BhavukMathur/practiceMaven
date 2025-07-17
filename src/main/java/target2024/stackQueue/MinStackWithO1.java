package target2024.stackQueue;

import java.util.Stack;

class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        // Push to minStack if it’s empty or val is <= current min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public int pop() {
        int removed = mainStack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
        return removed;
    }

    public int peek() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


public class MinStackWithO1 {

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(5);
		stack.push(2);
		stack.push(2);
		stack.push(1);
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		System.out.println(stack.getMin());
		System.out.println(stack.peek());
	}

}
