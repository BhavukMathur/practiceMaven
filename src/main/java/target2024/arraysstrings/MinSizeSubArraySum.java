package target2024.arraysstrings;

//https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150

public class MinSizeSubArraySum {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int target = 11;

		MinSizeSubArraySum msum = new MinSizeSubArraySum();
		System.out.println(msum.minSubArrayLen(target, arr));
	}

	public int minSubArrayLen(int target, int[] nums) {
		int minLength = Integer.MAX_VALUE;
		int sumSoFar = nums[0];
		int i=0, j=0, ind;


		while((i<=j) && (j < nums.length)) {
			if(sumSoFar < target) {
				j++;
				if(j == nums.length)
					break;
				sumSoFar = sumSoFar + nums[j];
			} else if (sumSoFar > target) {
				ind = j - i + 1;
				minLength = Math.min(minLength, ind);
				sumSoFar = sumSoFar - nums[i];
				i++;
			} else {
				//sumSoFar == target
				ind = j - i + 1;
				minLength = Math.min(minLength, ind);
				j++;
				if(j == nums.length)
					break;
				sumSoFar = sumSoFar + nums[j];
			}
		}
		if(minLength == Integer.MAX_VALUE) {
			return 0;
		}
		return minLength;
	}

}
