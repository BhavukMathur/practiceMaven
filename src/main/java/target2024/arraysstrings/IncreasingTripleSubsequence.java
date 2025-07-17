package target2024.arraysstrings;

//https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=company&envId=coupang&favoriteSlug=coupang-all
public class IncreasingTripleSubsequence {
	public static void main(String[] args) {
		IncreasingTripleSubsequence its = new IncreasingTripleSubsequence();
		int[] arr = {2, 1, 5, 0, 4, 6};
		System.out.println(its.increasingTriplet(arr));
	}

	public boolean increasingTriplet(int[] nums) {
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;

		for(int i=0; i<nums.length; i++) {
			if(nums[i] <= first) {
				first = nums[i];
			} else if(nums[i] <= second) {
				second = nums[i];
			} else {
				//first < second < nums[i]
				return true;
			}
		}
		return false;
	}

}
