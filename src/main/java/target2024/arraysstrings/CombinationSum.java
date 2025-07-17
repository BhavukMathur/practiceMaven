package target2024.arraysstrings;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {
	public static void main(String[] args) {
		//Similar to coin change
		int[] arr = {2, 3, 6, 7};
		int target = 7;
		int ways = ways(arr, target);
		System.out.println("Total ways: " + ways);

		List<List<Integer>> result = combinationSum(arr, target);
		result.forEach(list -> {
			System.out.println(list);
		});
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<>();
		Stack<Integer> coinsSoFar = new Stack<>();
		combinationSumRec(candidates, target, result, 0, coinsSoFar, 0);
		return result;
	}


	public static void combinationSumRec(
			int[] candidates, int target, List<List<Integer>> result, int sumSoFar, Stack<Integer> coinsSoFar, int ind
	) {
		if(sumSoFar == target) {
			List<Integer> newList = new LinkedList(coinsSoFar);
			result.add(newList);
			return;
		}
		if(sumSoFar > target) {
			return;
		}

		for(int i=ind; i<candidates.length; i++) {
			coinsSoFar.push(candidates[i]);
			combinationSumRec(candidates, target, result, sumSoFar + candidates[i], coinsSoFar, i);
			coinsSoFar.pop();
		}
	}



	public static Integer ways(int[] candidates, int target) {
		int dp[] = new int[target+1];
		dp[0] = 1;

		//For each coin
		//For i = coin to amount
		for(int i=0; i<candidates.length; i++) {
			for(int j=candidates[i]; j<=target; j++) {
				dp[j] = dp[j] + dp[j-candidates[i]];
			}
		}
		return dp[target];
	}
}
