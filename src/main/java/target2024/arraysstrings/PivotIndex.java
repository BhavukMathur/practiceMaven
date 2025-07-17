package target2024.arraysstrings;

import java.util.Arrays;

public class PivotIndex {
	public static void main(String[] args) {
		PivotIndex pi = new PivotIndex();
		int[] arr = {1,7,3,6,5,6};
		System.out.println(pi.pivotIndex(arr));
	}

	public int pivotIndex(int[] nums) {
		int totalSum = 0;
		for(int i=0; i<nums.length; i++) {
			totalSum = totalSum + nums[i];
		}
		System.out.println(totalSum);

		int leftSum=0, rightSum;
		for(int i=0; i<nums.length; i++) {
			rightSum = totalSum - leftSum - nums[i];
			if(leftSum == rightSum) {
				return i;
			} else {
				leftSum = leftSum + nums[i];
			}
		}

		return -1;
	}

}
