package target2024.arraysstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/permutations/description/
public class Permutations {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		List<List<Integer>> result = permute(arr);
		result.forEach(list -> {
			System.out.println(list);
		});
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		permuteRec(nums, result, 0);
		return result;
	}

	public static void permuteRec(int[] arr, List<List<Integer>> result, int index) {
		if (index == arr.length - 1) {
//			System.out.println(Arrays.toString(arr));
			List<Integer> list = new LinkedList<>();
			for(int i=0; i<arr.length; i++) {
				list.add(arr[i]);
			}
			result.add(list);
		} else {
			for (int i = index; i < arr.length; i++) {
				swap(arr, index, i);
				permuteRec(arr, result, index + 1);
				swap(arr, index, i); // backtrack
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
