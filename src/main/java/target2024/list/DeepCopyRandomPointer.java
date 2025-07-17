package target2024.list;

import lombok.AllArgsConstructor;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RandomNode {
	int val;
	RandomNode next;
	RandomNode random;
	public RandomNode(int val) {
		this.val = val;
	}

	public static RandomNode insert(RandomNode head, int val) {
		if(head == null) {
			head = new RandomNode(val);
		} else {
			RandomNode trv = head;
			while(trv.next != null) {
				trv = trv.next;
			}
			trv.next = new RandomNode(val);
		}
		return head;
	}

	public static void printNode(RandomNode head) {
		RandomNode trv = head;
		while(trv != null) {
			System.out.print(trv.val + "-->");
			trv = trv.next;
		}
		System.out.println();
	}

	public static RandomNode copyRandomList(RandomNode head) {
		//First create the nodes
		RandomNode newHead = null;
		RandomNode trv = head;
		//Create a map of value and randomNode and iterate
		return null;
	}
}

public class DeepCopyRandomPointer {
	public static void main(String[] args) {
		int[] arr = {7, 13, 11, 10, 1};
		RandomNode head = null;
		for(int i=0; i<arr.length; i++) {
			head = RandomNode.insert(head, arr[i]);
		}
		RandomNode.printNode(head);
		head.random = null;
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next;
		head.next.next.next.next.random = head;
	}

}
