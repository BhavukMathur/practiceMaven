package target2024.arraysstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SwapsToSortArray {
	public static void main(String[] args) {
		int[] arr = {20, 50, 40, 10, 30};
		int[] brr = new int[arr.length];

		for(int i=0; i<brr.length; i++) {
			brr[i] = arr[i];
		}
		Arrays.sort(brr);

		Map<Integer, Integer> indexByValue = new HashMap<>();
		for(int i=0; i<brr.length; i++) {
			indexByValue.put(brr[i], i);
		}

		int val, swap=0, correctPos;
		for(int i=0; i<arr.length; i++) {
			val = arr[i];
			if (indexByValue.get(val) == i) {
				//Element already at the correct place, do nothing
			} else {
				//Swap to pu this at its correct place
				correctPos = indexByValue.get(val);
				arr[i] = arr[correctPos];
				arr[correctPos] = val;
				swap++;
				i--;
			}
		}

		System.out.println("Total swaps = " + swap);
	}
}
