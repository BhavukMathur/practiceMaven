package target2024.arraysstrings;

//https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {
	public static void main(String[] args) {
		int arr[] = {0,1,2,2,3,0,4,2};
		int val = 2;

		RemoveElement re = new RemoveElement();
		System.out.println(Arrays.toString(arr));
		System.out.println(re.removeElement(arr, val));
		System.out.println(Arrays.toString(arr));
	}

	public int removeElement(int[] nums, int val) {
		int diff = 0;
		List<Integer> brr = new ArrayList<>();

		for(int i=0; i<nums.length; i++) {
			if(nums[i] == val) {
				nums[i] = -1;
			} else {
				diff++;
				brr.add(nums[i]);
			}
		}

		System.out.println(brr);
		//Update the array
		for(int i=0; i<brr.size(); i++) {
			nums[i] = brr.get(i);
		}

		return diff;
	}
}
