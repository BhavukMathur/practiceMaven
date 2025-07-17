package target2024.dynamicProgramming;

import java.util.Arrays;

public class MinJumpsToReachEnd {

	public static void main(String[] args) {
		MinJumpsToReachEnd mj = new MinJumpsToReachEnd();
		int[] nums = {2, 3, 1, 1, 4};
		System.out.println("Minimum jumps: " + mj.jump(nums)); // Output: 2
	}

	public int jump(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];

		// Initialize the dp array with a large number.
		for (int i = 0; i < n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		// Start position has 0 jumps needed to reach it.
		dp[0] = 0;

		// Loop through each index of the array.
		for (int i = 0; i < n; i++) {
			// Check up to nums[i] steps forward from the current position.
			for (int j = 1; j <= nums[i] && i + j < n; j++) {
				// Update the dp value for the position we can jump to.
				dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
			}
		}

		// The last element of dp array gives the minimum number of jumps to reach the last index.
		return dp[n - 1];
	}

}
