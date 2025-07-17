package target2024.dynamicProgramming;

//https://leetcode.com/problems/unique-paths-ii/?envType=company&envId=coupang&favoriteSlug=coupang-all
public class UniquePathsII {
	public static void main(String[] args) {
		UniquePathsII up2 = new UniquePathsII();
		int[][] grid = {
				{0,0,0},
				{0,1,0},
				{0,0,0}
		}; 		//1 obstacle, 0 path

		System.out.println(up2.uniquePathsWithObstacles(grid));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				dp[i][j] = -1;
			}
		}
		int totalWays = uniquePathsWithObstacles(obstacleGrid, m-1, n-1, 0, dp);
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(obstacleGrid[i][j] + " ");
			}
			System.out.println();
		}

		return totalWays;
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid, int m, int n, int totalWays, int[][] dp) {
		if(m < 0 || n < 0) {
			return totalWays;
		}
		if(m == 0 && n == 0) {
			if(obstacleGrid[m][n] == 0) {
				//Path found
				dp[m][n] = 1;
				return totalWays + 1;
			} else {
				return totalWays;
			}
		}
		if(obstacleGrid[m][n] == 1) {
			return totalWays;
		}
		if(dp[m][n] != -1) {
			return dp[m][n];
		}

		int up = uniquePathsWithObstacles(obstacleGrid, m, n-1, totalWays, dp);
		int left = uniquePathsWithObstacles(obstacleGrid, m-1, n, totalWays, dp);

		dp[m][n] = up + left;
		return dp[m][n];
	}

}
