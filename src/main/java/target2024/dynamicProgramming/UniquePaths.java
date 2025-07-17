package target2024.dynamicProgramming;

public class UniquePaths {
//	public int totalWays = 0;
	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		int m = 3, n = 7;
		System.out.println(up.uniquePaths(m, n));
	}

	public int uniquePaths(int m, int n) {
		int[][] dpWays = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				dpWays[i][j] = -1;
			}
		}
		int totalWays = uniquePaths(m-1, n-1, dpWays, 0);

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(dpWays[i][j] + " ");
			}
			System.out.println();
		}

		return totalWays;
	}

	public int uniquePaths(int m, int n, int[][] dpWays, int totalWays) {
		if(m < 0 || n < 0) {
			return totalWays;
		}
		if(m == 0 && n == 0) {
			//Path found
			dpWays[m][n] = 1;
			return (totalWays + 1);
		}

		if(dpWays[m][n] != -1) {
			return dpWays[m][n];
		}

		int up = uniquePaths(m, n-1, dpWays, totalWays);
		int left = uniquePaths(m-1, n, dpWays, totalWays);

		dpWays[m][n] = up + left;
		return dpWays[m][n];
	}
}
