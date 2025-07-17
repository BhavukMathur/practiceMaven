package target2024.treeHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthMaxMin {
	public static void main(String[] args) {
		int k = 3;
		int arr[] = {8, 4, 9, 2, 7, 10, 1, 3, 6, 0, 5};

		//Kth Min --> max Heap --> reverse order of PQ
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

		//Kth Max --> min Heap --> default order of PQ
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

		for(int i=0; i<arr.length; i++) {
			if(maxHeap.size() < k) {
				maxHeap.add(arr[i]);
			} else if (maxHeap.peek() > arr[i]) {
				maxHeap.poll();
				maxHeap.add(arr[i]);
			}

			if(minHeap.size() < k) {
				minHeap.add(arr[i]);
			} else if (minHeap.peek() < arr[i]) {
				minHeap.poll();
				minHeap.add(arr[i]);
			}
		}

		System.out.println(k + "th min number = " + maxHeap);
		System.out.println(k + "th max number = " + minHeap);
	}
}
