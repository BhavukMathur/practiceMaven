package target2024.stackQueue;

import java.util.Stack;

/**
 * add
 * poll
 * peek
 */
class CustomQueue {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	int frontVal;

	CustomQueue() {
		stack1 = new Stack();
		stack2 = new Stack();
	}

	void add(int val) {
		if(stack1.isEmpty()) {
			frontVal = val;
		}
		stack1.add(val);
	}

	int poll() {
		if(stack2.isEmpty()) {
			prepareStacks(stack1, stack2);
		}
		return stack2.pop();
	}

	int peek() {
		if(!stack2.isEmpty()) {
			return stack2.peek();
		} else {
			return frontVal;
		}
	}

	private void prepareStacks(Stack stk1, Stack stk2) {
		while(!stk1.isEmpty()) {
			stk2.add(stk1.pop());
		}
	}
}

public class QueueUsingStacks {
	public static void main(String[] args) {
		CustomQueue cq = new CustomQueue();
		cq.add(0);
		cq.add(1);
		cq.add(2);
		cq.add(3);
		cq.add(4);

		//0 <-- 1 <-- 2 <-- 3 <-- 4
		System.out.println(cq.poll());
		System.out.println(cq.poll());
		System.out.println(cq.poll());

		System.out.println(cq.peek());

		//3 <-- 4
		cq.add(5);
		cq.add(6);

		System.out.println(cq.peek());
	}
}
