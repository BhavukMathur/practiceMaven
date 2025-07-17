package target2024.list;

public class MergeSortLinkedList {
	public static void main(String[] args) {
		int[] arr = {7, 10, 2, 6, 1, 8, 3, 9, 5, 4};
		Node head = null;

		for(int i=0; i<arr.length; i++) {
			head = ReverseLinkedList.insert(head, arr[i]);
		}
		ReverseLinkedList.print(head);

		head = mergeSort(head);
		System.out.println("\nSorted List:");
		ReverseLinkedList.print(head);

	}

	private static Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node middle = getMiddle(head);
		Node nextOfMiddle = middle.next;
		middle.next = null;

		Node left = mergeSort(head);
		Node right = mergeSort(nextOfMiddle);

		return sortedMerge(left, right);
	}

	private static Node getMiddle(Node head) {
		if (head == null) {
			return head;
		}

		Node slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static Node sortedMerge(Node left, Node right) {
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}

		Node result;
		if (left.val <= right.val) {
			result = left;
			result.next = sortedMerge(left.next, right);
		} else {
			result = right;
			result.next = sortedMerge(left, right.next);
		}
		return result;
	}
}
