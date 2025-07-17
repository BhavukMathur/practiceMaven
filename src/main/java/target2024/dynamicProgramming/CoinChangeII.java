package target2024.dynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/?envType=study-plan-v2&envId=top-interview-150
public class CoinChangeII {
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		CoinChangeII cc2 = new CoinChangeII();
		System.out.println(cc2.coinChange(coins, amount));
	}

	public int coinChange(int[] coins, int amount) {
		if (amount == 0)
		{
			return 0;
		}

		// Create an array to store the minimum number of coins needed for each amount from 0 to amount
		int[] dp = new int[amount + 1];
		// Fill the array with a large number to represent an initially unachievable amount
		Arrays.fill(dp, amount + 1);
		// There are 0 coins needed to make the amount 0
		dp[0] = 0;

		// Iterate over all coin denominations
		for (int coin : coins) {
			// Check every amount from 1 to amount
			for (int amt = coin; amt <= amount; amt++) {
				// Update dp[amt] to be the minimum of its current value or the value using this coin denomination
				dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
			}
		}
		// If dp[amount] is still a large number, it means it's not possible to form the amount with given coins
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
