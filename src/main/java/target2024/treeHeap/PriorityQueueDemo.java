package target2024.treeHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		int[] arr = {10, 2, 15, 1, 5, 12, 20, 4};
		//Min Heap by default
//		PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length, Collections.reverseOrder());
		PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length);
		for(int i=0; i<arr.length; i++) {
			pq.add(arr[i]);
		}

		while(!pq.isEmpty()) {
			System.out.println("Priority queue=" + pq);
			System.out.println("Polling - " + pq.poll());
		}
	}
}
