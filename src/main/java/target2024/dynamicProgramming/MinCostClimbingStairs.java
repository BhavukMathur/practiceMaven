package target2024.dynamicProgramming;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/?envType=study-plan-v2&envId=dynamic-programming
 */
public class MinCostClimbingStairs {
	public static void main(String[] args) {
		int[] cost = {1,100,1,1,1,100,1,1,100,1};
		MinCostClimbingStairs mc = new MinCostClimbingStairs();
		System.out.println(mc.minCostClimbingStairs(cost));
	}

	public int minCostClimbingStairs(int[] cost) {
		int costSoFar[] = new int[cost.length];
		costSoFar[0] = costSoFar[1] = 0;

		for(int i=2; i<cost.length; i++) {
			costSoFar[i] = Math.min((costSoFar[i-1] + cost[i-1]), (costSoFar[i-2] + cost[i-2]));
		}

		int len = cost.length;
		return Math.min((costSoFar[len-1] + cost[len-1]), (costSoFar[len-2] + cost[len-2]));
	}

	public int minCostClimbingStairsBrute(int[] cost) {
		int total = 0;
		return minCostBrute(cost, total, -1);
	}

	public int minCostBrute(int[] cost, int total, int ind) {
		if(ind >= cost.length) {
			return total;
		}
		int oneInd = ind + 1;
		int twoInd = ind + 2;

		int oneCost = total;
		int twoCost = total;

		if(oneInd < cost.length)
			oneCost = minCostBrute(cost, total + cost[oneInd], oneInd);

		if(twoInd < cost.length)
			twoCost = minCostBrute(cost, total + cost[twoInd], twoInd);

		return Math.min(oneCost, twoCost);
	}

}
