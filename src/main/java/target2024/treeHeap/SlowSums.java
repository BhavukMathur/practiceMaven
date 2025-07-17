package target2024.treeHeap;

import java.util.Collections;
import java.util.PriorityQueue;

//https://www.metacareers.com/profile/coding_practice_question/?problem_id=836241573518034&c=1373057600385980&psid=275492097255885&practice_plan=0&b=0111122
public class SlowSums {
	public static void main(String[] args) {
		int[] arr = {4, 2, 1, 3};
		SlowSums slowSums = new SlowSums();
		System.out.println(slowSums.getTotalTime(arr));
	}

	int getTotalTime(int[] arr) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<arr.length; i++) {
			maxHeap.add(arr[i]);
		}

		int penalty = 0, a, b;
		while(maxHeap.size() >= 2) {
			a = maxHeap.poll();
			b = maxHeap.poll();
			penalty = penalty + a + b;
			maxHeap.add(a + b);
		}
		return penalty;
	}

}
