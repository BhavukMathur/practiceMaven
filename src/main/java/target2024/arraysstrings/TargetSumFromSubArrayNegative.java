package target2024.arraysstrings;

import java.util.HashMap;
import java.util.Map;

public class TargetSumFromSubArrayNegative {
	public static void main(String[] args) {
		int[] arr = {-2, -6, -1, 9, 7, 3};
		int sum = 8;

		Map<Integer, Integer> sumByIndex = new HashMap<>();

		int sumSoFar = 0;
		int brr[] = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			sumSoFar = sumSoFar + arr[i];
			brr[i] = sumSoFar;
			sumByIndex.put(sumSoFar, i);
		}

		int start=0, end=0;
		boolean foundFlag = false;
		for(int i=0; i<brr.length; i++) {
			if(brr[i] == sum) {
				end=i;
				foundFlag = true;
				break;
			} else if (sumByIndex.containsKey(brr[i] - sum)) {
				start = sumByIndex.get(brr[i] - sum) + 1;
				end = i;
				foundFlag = true;
				break;
			}
		}

		if(foundFlag) {
			System.out.println("Match found " + start + " " + end);
		} else {
			System.out.println("Not found");
		}
	}
}
