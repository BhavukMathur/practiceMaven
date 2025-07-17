package target2024.treeHeap;

import java.util.Arrays;

public class KthLargestNumber {
	public static void main(String[] args) {
		int[] arr = {10, 2, 15, 1, 5, 12, 20};
		int k = 3;

		int[] minHeap = new int[k]; //But put large numbers here

		for(int i=0; i<k; i++) {
			minHeap[i] = Integer.MIN_VALUE;
		}

		for(int i=0; i<arr.length; i++) {
			if(arr[i] <= minHeap[0]) {
				//Do nothing
			} else {
				minHeap[0] = arr[i];
				minHeapify(minHeap, 0);
			}
		}

		System.out.println("\nMin Heap formed");
		System.out.println(Arrays.toString(minHeap));
		System.out.println("\n" + k + "rd/th largest number is = " + minHeap[0]);
	}

	private static void minHeapify(int[] minHeap, int ind) {
		if(ind >= minHeap.length) {
			return;
		}

		int smallest = minHeap[ind];
		int left = 2*ind + 1;
		int right = 2*ind + 2;

		if(left < minHeap.length && minHeap[left] < smallest) {
			smallest = minHeap[left];
		}
		if(right < minHeap.length && minHeap[right] < smallest) {
			smallest = minHeap[right];
		}

		if(smallest == minHeap[ind]) {
			return;
		}
		if(smallest == minHeap[left]) {
			minHeap[left] = minHeap[ind];
			minHeap[ind] = smallest;
			minHeapify(minHeap, 2*ind + 1);
		}
		else if(smallest == minHeap[right]) {
			minHeap[right] = minHeap[ind];
			minHeap[ind] = smallest;
			minHeapify(minHeap, 2*ind + 2);
		}
	}
}
