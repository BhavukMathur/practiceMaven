package target2024.dynamicProgramming;

import java.util.Arrays;

public class CanJumpToTheEnd {
	public static void main(String[] args) {
		CanJumpToTheEnd cj = new CanJumpToTheEnd();
		int[] arr = {3,2,1,1,4};
//		int[] arr = {2,3,1,1,4};
		System.out.println(cj.canJump(arr));
	}

	public boolean canJump(int[] nums) {
		boolean memo[] = new boolean[nums.length];
		Arrays.fill(memo, true);
		return canJumpDP(nums, 0, memo);
	}

	public boolean canJumpDP(int[] nums, int ind, boolean[] memo) {
		if(ind >= nums.length-1) {
			return true;
		}
		if(memo[ind] == false) {
			return false;
		}
		int val = nums[ind];
		boolean canJump;
		for(int i=ind+1; i<ind+val+1; i++) {
			canJump = canJumpDP(nums, i, memo);
			memo[i] = canJump;
			if(canJump) {
				return canJump;
			}
		}
		return false;
	}
}
