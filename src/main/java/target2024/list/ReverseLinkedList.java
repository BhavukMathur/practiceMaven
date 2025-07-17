package target2024.list;

public class ReverseLinkedList {
	public static void main(String[] args) {
		Node head = null;
		int[] arr = {10, 20, 30, 40, 50, 60};

		for(int i=0; i<arr.length; i++) {
			head = insert(head, arr[i]);
		}
		print(head);
		head = reverse(head);
		System.out.println("Reversing the linked list");
		print(head);
	}

	private static Node reverse(Node head) {
		if(head.next == null) {
			return head;
		}
		Node p=null, q=head, r=head.next;

		while(r != null) {
			q.next = p;
			p = q;
			q = r;
			r = r.next;
		}
		q.next = p;
		head = q;
		return head;
	}

	public static void print(Node head) {
		Node trv = head;
		while(trv != null) {
			System.out.print(trv.val + "-->");
			trv = trv.next;
		}
	}

	public static Node insert(Node head, int val) {
		Node temp = new Node();
		temp.next = null;
		temp.val = val;

		if(head == null) {
			head = temp;
			return head;
		} else {
			Node trv = head;
			while(trv.next != null) {
				trv = trv.next;
			}
			trv.next = temp;
			return head;
		}
	}
}
