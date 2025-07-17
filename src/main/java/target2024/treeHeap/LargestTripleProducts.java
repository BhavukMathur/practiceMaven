package target2024.treeHeap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LargestTripleProducts {
	public static void main(String[] args) {
		int[] arr = {2, 4, 7, 1, 5, 3};
		LargestTripleProducts lp = new LargestTripleProducts();
		System.out.println(Arrays.toString(lp.findMaxProduct(arr)));
	}

	int[] findMaxProduct(int[] arr) {
		//Need three largest numbers
		//Min heap --> default
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		System.out.println(pq.size());
		int size = 3;

		int[] result = new int[arr.length];
		int product = 1;
		for(int i=0; i<arr.length; i++) {
			if(i < size-1) {
				result[i] = -1;
				pq.add(arr[i]);
				product = product * arr[i];
			} else if (i == size-1) {
				pq.add(arr[i]);
				product = product * arr[i];
				result[i] = product;
			} else {
				if(pq.peek() > arr[i]) {
					result[i] = product;
				} else {
					product = (product / pq.peek()) * arr[i];
					result[i] = product;
					pq.poll();
					pq.add(arr[i]);
				}
			}
		}
		return result;
	}
}
