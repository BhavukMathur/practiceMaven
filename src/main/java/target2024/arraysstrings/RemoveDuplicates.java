package target2024.arraysstrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Modify the array as well to have only the unique elements
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 * Efficient way to use last element since array is sorted
 */
public class RemoveDuplicates {
	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		int[] arr = {0,0,1,1,1,2,2,3,3,4};
		int result = rd.removeDuplicates(arr);
		System.out.println(result);
	}

	public int removeDuplicates(int[] nums) {
		Set<Integer> hashSet = new HashSet<>();
		List<Integer> arr = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			if(!hashSet.contains(nums[i])) {
				hashSet.add(nums[i]);
				arr.add(nums[i]);
			}
		}

		for(int i=0; i<arr.toArray().length; i++) {
			nums[i] = arr.get(i);
		}

		return hashSet.size();
	}
}
