package target2024.graph;

//https://leetcode.com/problems/rotting-oranges/description/
public class RottenOranges {
	static int depth = Integer.MIN_VALUE;
	public static void main(String[] args) {
//		int[][] arr = {{2,1,1},
//				       {0,1,1},
//				       {1,0,1}};

		int[][] arr = {{0, 2}};

		System.out.println("Time for all oranges to rot =" + orangesRotting(arr));
	}

	public static int orangesRotting(int[][] grid) {

		int rotI=0, rotJ=0;

		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 2) {
					rotI = i;
					rotJ = j;
				}
			}
		}

		grid[rotI][rotJ] = 1;
		orangesRottingRec(grid, rotI, rotJ, 0);

		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
//				System.out.print(grid[i][j] + " ");
				if(grid[i][j] == 1) {
					return -1;
				}
			}
			System.out.println();
		}
		return depth;
	}

	public static void orangesRottingRec(int[][] grid, int i, int j, int depthSoFar) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return;
		}

		if(grid[i][j] == 0 || grid[i][j] == 2) {
			return;
		}

		if(depthSoFar > depth) {
			depth = depthSoFar;
		}

		grid[i][j] = 2;

		//Move in all directions
		orangesRottingRec(grid, i, j+1, depthSoFar+1);
		orangesRottingRec(grid, i+1, j, depthSoFar+1);
		orangesRottingRec(grid, i, j-1, depthSoFar+1);
		orangesRottingRec(grid, i-1, j, depthSoFar+1);
	}

}
