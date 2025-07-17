package target2024.treeHeap;

import java.util.Arrays;

public class HeapMain {
	public static void main(String[] args) {
		int[] arr = {1, 2, 5, 10, 12, 15, 20};
		int[] brr = new int[arr.length];
		System.out.println(Arrays.toString(arr));

		System.out.println("\nBuilding Heap");
		for(int i=0; i<arr.length; i++) {
			brr[i] = arr[i];
			buildMaxHeap(brr, i);
			System.out.println(Arrays.toString(brr));
		}

		System.out.println("\nDeleting the Heap");
		int heapSize = brr.length, temp;

		while(heapSize > 0) {
			heapSize--;
			System.out.println("Deleting" + brr[0]);
			temp = brr[0];
			brr[0] = brr[heapSize];
			maxHeapifyAfterDeletion(brr, heapSize, 0);
		}
	}

	private static void maxHeapifyAfterDeletion(int[] brr, int heapSize, int ind) {
		if(heapSize < 0)
			return;

		if(ind > heapSize)
			return;

		int root = brr[ind];
		int tempMax = root;

		int leftInd = 2*ind + 1;
		int rightInd = 2*ind + 2;

		if(leftInd < heapSize && brr[leftInd] > tempMax) {
			tempMax = brr[leftInd];
		}

		if(rightInd < heapSize && brr[rightInd] > tempMax) {
			tempMax = brr[rightInd];
		}

		if(leftInd < heapSize && tempMax == brr[leftInd]) {
			brr[leftInd] = brr[ind];
			brr[ind] = tempMax;
			maxHeapifyAfterDeletion(brr, heapSize, leftInd);
		} else if (rightInd < heapSize && tempMax == brr[rightInd]) {
			brr[rightInd] = brr[ind];
			brr[ind] = tempMax;
			maxHeapifyAfterDeletion(brr, heapSize, rightInd);
		}
	}

	private static void buildMaxHeap(int[] brr, int ind) {
		if(ind == 0) {
			return;
		}

		//Compare with parent
		int pind = (ind-1)/2;
		int largest;

		if(brr[ind] > brr[pind]) {
			largest = brr[ind];
			brr[ind] = brr[pind];
			brr[pind] = largest;
			buildMaxHeap(brr, pind);
		}
	}
}
