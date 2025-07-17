package target2024.arraysstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.metacareers.com/profile/coding_practice_question/?problem_id=840934449713537&c=1373057600385980&psid=275492097255885&practice_plan=0&b=0111122
public class PairSum {
	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 3, 3};
		int k = 6;
		PairSum ps = new PairSum();
		System.out.println(ps.numberOfWays(arr, k));
	}

	int numberOfWays(int[] arr, int k) {
		int count = 0;
		Map<Integer, Integer> numHash = new HashMap<>();

		//Build the num count hashMap
		for(int i=0; i<arr.length; i++) {
			if(numHash.get(arr[i]) == null) {
				numHash.put(arr[i], 1);
			} else {
				numHash.put(arr[i], numHash.get(arr[i]) + 1);
			}
		}
		System.out.println(numHash);

		//Check for the sum
//		int[] arr = {1, 2, 3, 4, 3};
		Integer pair;
		for(int i=0; i<arr.length; i++) {
			pair = numHash.get(k - arr[i]);

			if(pair == null) {
				//Do nothing
			} else {
				if(arr[i] == (k - arr[i])) {
					int permutation = calculateCombination(numHash.get(arr[i]));
					count = count + permutation;
					numHash.remove(arr[i]);
				} else {
					count++;
					updateHash(numHash, (k-arr[i]));
					updateHash(numHash, (arr[i]));
				}
			}
		}
		return count;
	}

	private int calculateCombination(int n) {
		return (n * (n-1)) / 2;
	}

	private void updateHash(Map<Integer, Integer> numHash, int val) {
		if (numHash.get(val) == null) {
			//Do nothing
		} else if(numHash.get(val) == 1) {
			numHash.remove(val);
		} else {
			numHash.put(val, numHash.get(val) - 1);
		}
	}

}
