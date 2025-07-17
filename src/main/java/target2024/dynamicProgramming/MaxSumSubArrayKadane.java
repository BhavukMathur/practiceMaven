package target2024.dynamicProgramming;

public class MaxSumSubArrayKadane {
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		MaxSumSubArrayKadane ms = new MaxSumSubArrayKadane();
		System.out.println(ms.maxSubArray(nums));
	}

	public int maxSubArray(int[] nums) {
		int maxSoFar = nums[0];
		int maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
}
