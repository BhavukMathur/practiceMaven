package target2024.dynamicProgramming;

//https://leetcode.com/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-interview-150
public class ClimbingStairs {
	public static void main(String[] args) {
		ClimbingStairs cs = new ClimbingStairs();
		int n = 6;
		int ways = cs.climbStairs(n);
		System.out.println(ways);
	}

	public int climbStairs(int n) {
		int[] ways = new int[n+1];
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		ways[0] = 1;
		ways[1] = 1;
		ways[2] = 2;

		for(int i=3; i<=n; i++) {
			ways[i] = ways[i-1] + ways[i-2];
		}
		return ways[n];
	}
}
