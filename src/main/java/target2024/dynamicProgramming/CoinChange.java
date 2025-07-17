package target2024.dynamicProgramming;

//https://leetcode.com/problems/coin-change-ii/submissions/1483582634/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	static int finalAns = 0;
	public int change(int amount, int[] coins) {
		List<Integer> coinList = new ArrayList<>();
		countCoinWays(coins, amount, 0, coinList);
		return finalAns;
	}

	public int changeDP(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1; // Base case: one way to make amount 0

		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] = dp[i] + dp[i - coin];
			}
		}
//		System.out.println(Arrays.toString(dp));
		return dp[amount];
	}

	private static void countCoinWays(int[] coins, int remaining, int ind, List<Integer> coinList) {
		if(remaining < 0) {
			return;
		}

		if(remaining == 0)
		{
//			System.out.println(coinList);
			finalAns++;
		}

		for(int i=ind; i<coins.length; i++) {
			coinList.add(coins[i]);
			countCoinWays(coins, (remaining - coins[i]), i, coinList);
			coinList.remove(coinList.size() - 1);
		}
	}

}

public class CoinChange {
	public static void main(String[] args) {
		Solution ss = new Solution();
		int amount = 6;
		int[] coins = {1, 2, 5};
		int ways = ss.change(amount, coins);
		int waysDP = ss.changeDP(amount, coins);
		System.out.println("Total ways are - " + ways);
		System.out.println("Total dp ways are - " + waysDP);
	}
}
