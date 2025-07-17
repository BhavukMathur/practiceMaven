package target2024.backTracking;

import java.util.Stack;

public class CoinChangeBackTracking {
	static int totalWays = 0;
	public static void main(String[] args) {
		int coins[] = {2, 3, 5, 10};
		int sum = 20;
		int remaining = sum;
		Stack<Integer> coinList = new Stack<>();

		findWays(sum, remaining, coins, 0, coinList);
		System.out.println("Total number of ways are - " + totalWays);
	}

	private static void findWays(int sum, int remaining, int[] coins, int ind, Stack<Integer> coinList) {
		if(remaining < 0) {
			return;
		}
		if(remaining == 0) {
			totalWays++;
			System.out.println(coinList);
			return;
		}

		for(int i=ind; i< coins.length; i++) {
			coinList.add(coins[i]);
			findWays(sum, remaining-coins[i], coins, i, coinList);
			coinList.pop();
		}
	}
}
