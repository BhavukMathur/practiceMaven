package target2024.algorithms;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/continuous-subarray-sum/?envType=problem-list-v2&envId=7p59281
public class SubArraySumMultipleOfKPrefix {
	public static void main(String[] args) {
//		int[] arr = {23, 2, 4, 6, 7};
		int[] arr = {1, 0};
		int k = 2;
		System.out.println(checkSubarraySum(arr, k));
	}

	public static boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> remainderByIndex = new HashMap<>();
		int sumSoFar = 0, remainder; //prefix sum method
//		int[] arr = {23, 2, 4, 6, 7};
		for(int j=0; j<nums.length; j++) {
			sumSoFar = sumSoFar + nums[j];
			remainder = sumSoFar % k;
			if(remainderByIndex.containsKey(remainder)) {
				System.out.println("Pair is between : "
						+ (remainderByIndex.get(remainder)+1) + " -- " + (j));
				//Pair found
				return true;
			} else {
				remainderByIndex.put(remainder, j);
			}
		}
		if(remainderByIndex.containsKey(0) && nums[remainderByIndex.get(0)] != 0) {
			return true;
		}
		return false;
	}

}
