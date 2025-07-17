package target2024.dynamicProgramming;

//https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=top-interview-150
public class HouseRobber {
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		int[] nums = {2,1,1,2};
		System.out.println(hr.rob(nums));
	}

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		// edge cases with one or two houses
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int n = nums.length;
		int[] dp = new int[n];

		// Initialize base cases
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		// Fill the dp array with dynamic programming approach
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
		}

		// The answer is the last element in dp array which represents the maximum amount that can be robbed
		return dp[n - 1];
	}
}
