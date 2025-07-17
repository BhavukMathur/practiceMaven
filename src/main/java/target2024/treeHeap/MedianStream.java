package target2024.treeHeap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//https://www.metacareers.com/profile/coding_practice_question/?problem_id=547645422524434&c=1373057600385980&psid=275492097255885&practice_plan=0&b=0111122
public class MedianStream {
	public static void main(String[] args) {
		MedianStream ms = new MedianStream();
//		int[] arr = {5, 15, 1, 3};
		int[] arr = {0, 1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(ms.findMedian(arr)));
	}

	int[] findMedian(int[] arr) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		int[] result = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			//Insert into either minHeap or maxHeap
			if(minHeap.isEmpty() || arr[i] > minHeap.peek()) {
				minHeap.add(arr[i]);
			} else {
				maxHeap.add(arr[i]);
			}

			//Balance the two heaps
			if(minHeap.size() - maxHeap.size() > 1) {
				maxHeap.add(minHeap.poll());
			} else if (maxHeap.size() - minHeap.size() > 1) {
				minHeap.add(maxHeap.poll());
			} else {
				//Do nothing
			}

			//Calculate the result
			if(i%2 == 0) {
				result[i] = minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
			} else {
				result[i] = (minHeap.peek() + maxHeap.peek()) / 2;
			}
		}
		return result;
	}
}
