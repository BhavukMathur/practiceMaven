package target2024.graph;

public class Islands {
	public static void main(String[] args) {
		char[][] arr = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};

		Islands islands = new Islands();
		System.out.println(islands.numIslands(arr));
	}

	public int numIslands(char[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for(int i=0; i< grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				visited[i][j] = false;
			}
		}
		int count = 0;
		for(int i=0; i< grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if((visited[i][j] == false) && (grid[i][j] == '1')) {
					count++;
					mapIslandByIndex(grid, visited, i, j);
				}
			}
		}
		return count;
	}

	public void mapIslandByIndex(char[][] grid, boolean[][] visited, int i, int j) {
		if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
			return;
		}

		if(grid[i][j] == '0') {
			return;
		}

		if(visited[i][j] == true) {
			return;
		}

		visited[i][j] = true;

		//Checking in all directions
		mapIslandByIndex(grid, visited, i+1, j);
		mapIslandByIndex(grid, visited, i, j+1);
		mapIslandByIndex(grid, visited, i-1, j);
		mapIslandByIndex(grid, visited, i, j-1);
	}

}
