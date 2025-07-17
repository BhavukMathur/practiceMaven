package target2024.dynamicProgramming;

import java.util.Arrays;

//https://www.metacareers.com/profile/coding_practice_question/?problem_id=2903692913051025&c=1373057600385980&psid=275492097255885&practice_plan=0&b=0111122
public class CoinChange3 {
	public static void main(String[] args) {
		CoinChange3 cc3 = new CoinChange3();
		int[] coin = {5, 10, 25, 100, 200};
		int amount = 94;
		boolean result = cc3.canGetExactChangeRecursion(amount, coin);
		System.out.println("Can get exact change recursion? - " + result);

		boolean result2 = cc3.ways(coin, amount);
		System.out.println("Can get exact change dp? - " + result2);
	}

	public static boolean ways(int[] coins, int amount) {
		boolean[] dp = new boolean[amount+1];
		Arrays.fill(dp, false);
		dp[0] = true;

		for(int coin: coins) {
			for(int j=coin; j<amount+1; j++) {
				dp[j] = dp[j] || dp[j-coin];
			}
		}
		return dp[amount];
	}

	boolean canGetExactChangeRecursion(int targetMoney, int[] denominations) {
		return canGetExactChangeRecursion2(denominations, targetMoney, 0);
	}

	boolean canGetExactChangeRecursion2(int[] denominations, int remaining, int ind) {
		if(remaining == 0) {
			return true;
		}
		if(remaining < 0 || ind >= denominations.length) {
			return false;
		}

		boolean result;
		for(int i=ind; i<denominations.length; i++) {
			result = canGetExactChangeRecursion2(
					denominations,
					remaining - denominations[i], i);
			if(result == true) {
				return true;
			}
		}
		return false;
	}

}
