package target2024.arraysstrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/3sum/description/
//3 separate indexes such that sum is 0
public class TripleSum {
	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		System.out.println(Arrays.toString(arr));
		List<List<Integer>> result = threeSum(arr);
		result.forEach(list -> {
			System.out.println(list);
		});
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		int[] brr = nums.clone();
		Arrays.sort(brr);
		System.out.println(Arrays.toString(brr));
		int target;
		Set<String> tripletSet = new HashSet<>();
		//[-4, -1, -1, 0, 1, 2]
		for(int i=0; i<brr.length; i++) {
			target = 0 - brr[i]; //4

			int j = i+1;
			int k = brr.length - 1;

			while(j < k) {
				if(brr[j] + brr[k] == target) {
					//Triplet found
					//Check for existing result
					String str = brr[i] + ":" + brr[j] + ":" + brr[k];
					if(tripletSet.contains(str)) {
						//Do nothing
					} else {
						LinkedList list = new LinkedList<>();
						list.add(brr[i]); list.add(brr[j]); list.add(brr[k]);
						result.add(list);
						tripletSet.add(str);
					}
					j++;
					k--;
				}
				else if(brr[j] + brr[k] < target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return result;
	}
}
