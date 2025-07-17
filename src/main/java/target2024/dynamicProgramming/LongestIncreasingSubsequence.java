package target2024.dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] dp = new int[nums.length];
		int maxLength = 1;

		// Initialize dp array where each element is 1 (each element is an increasing subsequence of length 1)
		Arrays.fill(dp, 1);

		// Iterate through the array
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				// If nums[i] is greater than nums[j], update dp[i]
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			// Update the maximum length of increasing subsequence found so far
			maxLength = Math.max(maxLength, dp[i]);
		}

		return maxLength;
	}
}
