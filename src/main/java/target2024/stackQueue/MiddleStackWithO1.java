package target2024.stackQueue;

class StackWithMiddleOperation {
    private class DLLNode {
        int data;
        DLLNode prev, next;
        DLLNode(int data) { this.data = data; }
    }

    private DLLNode head, mid;
    private int count;

    public StackWithMiddleOperation() {
        head = mid = null;
        count = 0;
    }

    public void push(int data) {
        DLLNode newNode = new DLLNode(data);
        newNode.next = head;

        if (head != null)
            head.prev = newNode;
        head = newNode;

        count++;

        if (count == 1)
            mid = newNode;
        else if (count % 2 == 0)
            mid = mid.prev;
    }

    public int pop() {
        if (count == 0) throw new RuntimeException("Stack underflow");

        int data = head.data;
        head = head.next;

        if (head != null)
            head.prev = null;

        count--;

        if (count % 2 == 1 && mid != null)
            mid = mid.next;

        return data;
    }

    public int top() {
        if (count == 0) throw new RuntimeException("Stack is empty");
        return head.data;
    }

    public int findMiddle() {
        if (count == 0) throw new RuntimeException("Stack is empty");
        return mid.data;
    }

    public void deleteMiddle() {
        if (count == 0) throw new RuntimeException("Stack is empty");

        if (count == 1) {
            head = mid = null;
            count = 0;
            return;
        }

        DLLNode prev = mid.prev;
        DLLNode next = mid.next;

        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;

        if (count % 2 == 0)
            mid = prev;
        else
            mid = next;

        count--;
    }
}


public class MiddleStackWithO1 {

	public static void main(String[] args) {
		StackWithMiddleOperation s = new StackWithMiddleOperation();
		s.push(1); // Stack: [1], Mid: 1
		s.push(2); // Stack: [2, 1], Mid: 2
		s.push(3); // Stack: [3, 2, 1], Mid: 2
		s.findMiddle(); // returns 2
		s.deleteMiddle(); // Stack: [3, 1], Mid: 3
		s.findMiddle(); // returns 3
	}

}
