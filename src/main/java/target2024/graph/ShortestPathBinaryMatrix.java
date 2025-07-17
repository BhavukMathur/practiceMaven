package target2024.graph;

public class ShortestPathBinaryMatrix {
	public int minSoFar = Integer.MAX_VALUE;
	public static void main(String[] args) {
		ShortestPathBinaryMatrix ss = new ShortestPathBinaryMatrix();
//		int[][] arr = {
//				{0,0,0},
//				{1,1,0},
//				{1,1,0}
//		};
		int[][] arr = {
				{0,1},
				{1,0}
		};
		System.out.println(ss.shortestPathBinaryMatrix(arr));
	}

	public int shortestPathBinaryMatrix(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		shortestPathBinaryMatrixRec(grid, 1, 0, 0, visited);
		return (minSoFar == Integer.MAX_VALUE ? -1 : minSoFar);
	}


	public void shortestPathBinaryMatrixRec(int[][] grid, int distSoFar, int i, int j, boolean[][] visited) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return;
		}
		if(grid[i][j] != 0) {
			return;
		}
		if((i == grid.length - 1) && (j == grid[0].length - 1)) {
			if(distSoFar < minSoFar) {
				minSoFar = distSoFar;
			}
			return;
		}
		if(distSoFar > minSoFar) {
			return;
		}
		if(visited[i][j] == true) {
			return;
		}

		visited[i][j] = true;
		shortestPathBinaryMatrixRec(grid, distSoFar+1, i-1, j, visited);
		shortestPathBinaryMatrixRec(grid, distSoFar+1, i-1, j+1, visited);
		shortestPathBinaryMatrixRec(grid, distSoFar+1, i, j+1, visited);
		shortestPathBinaryMatrixRec(grid, distSoFar+1, i+1, j+1, visited);
		shortestPathBinaryMatrixRec(grid, distSoFar+1, i+1, j, visited);
		shortestPathBinaryMatrixRec(grid, distSoFar+1, i+1, j-1, visited);
		shortestPathBinaryMatrixRec(grid, distSoFar+1, i, j-1, visited);
		shortestPathBinaryMatrixRec(grid, distSoFar+1, i-1, j-1, visited);
		visited[i][j] = false;
	}
}
