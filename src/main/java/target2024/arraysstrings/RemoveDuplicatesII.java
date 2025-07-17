package target2024.arraysstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicatesII {
	public static void main(String[] args) {
		RemoveDuplicatesII rd = new RemoveDuplicatesII();
//		int[] arr = {0,0,1,1,1,2,2,2,3,4,4};
		int[] arr = {1,1,1,2,2,3};
		System.out.println(Arrays.toString(arr));
		int result = rd.removeDuplicates(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(result);
	}

	public int removeDuplicates(int[] arr) {
		Map<Integer, Integer> numCount = new HashMap<>();
		int[] brr = new int[arr.length];

		int temp, j=0, finalCount=0;
		for(int i=0; i<arr.length; i++) {
			temp = arr[i];
			if(numCount.get(temp) == null) {
				numCount.put(temp, 1);
				brr[j++] = temp;
				finalCount++;
			} else if(numCount.get(temp) < 2) {
				numCount.put(temp, numCount.get(temp) + 1);
				brr[j++] = temp;
				finalCount++;
			} else {
				//Do nothing
			}
		}

		for(int i=0; i<brr.length; i++) {
			arr[i] = brr[i];
		}
		return finalCount;
	}
}
