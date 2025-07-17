package target2024.arraysstrings;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
/**
 * Maintain remainders of the sum
 */
public class SubArrayDivisibleByK {
	public static void main(String[] args) {
		int[] arr = {4, 5, 0, -2, -3, 1};
		int k = 5;
		//There are 7 subarrays with a sum divisible by k = 5:
		//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

		SubArrayDivisibleByK sk = new SubArrayDivisibleByK();
		System.out.println(sk.subarraysDivByK(arr, k));
	}

	public int subarraysDivByK(int[] nums, int k) {
		int curSum = 0;
		int result = 0;
		Map<Integer, Integer> remainderCount = new HashMap<>();
		remainderCount.put(0, 1);

		for(int i=0; i<nums.length; i++) {
			curSum = curSum + nums[i];
			int remainder = ((curSum % k) + k) % k;

			if(remainderCount.containsKey(remainder)) {
				result = result + remainderCount.get(remainder);
			}

			remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
		}
		return result;
	}

}
