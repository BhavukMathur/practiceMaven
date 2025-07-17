package target2024.graph;

//Partially correct
public class SurroundedRegion {
	public static void main(String[] args) {
//		char[][] arr = {{'O','O','O','O','X','X'},
//						{'O','O','O','O','O','O'},
//						{'O','X','O','X','O','O'},
//						{'O','X','O','O','X','O'},
//						{'O','X','O','X','O','O'},
//						{'O','X','O','O','O','O'}
//		};
		char[][] arr = {{'X','X','X','X'},
						{'X','O','O','X'},
						{'X','X','O','X'},
						{'X','O','X','X'}};

		SurroundedRegion sr = new SurroundedRegion();

		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		sr.solve(arr);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void solve(char[][] board) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j] == 'O' && visited[i][j] == false) {
					canCapture(board, i, j, visited);
				}
			}
		}
	}

	public boolean canCapture(char[][] board, int i, int j, boolean[][] visited) {
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return false;
		}
		if(board[i][j] == 'X') {
			return true;
		}
		if(visited[i][j] == true) {
			return true;
		}

		visited[i][j] = true;
		//If any side returns false, else true
		boolean canCapture = canCapture(board, i+1, j, visited) &&
				canCapture(board, i, j+1, visited) &&
				canCapture(board, i-1, j, visited) &&
				canCapture(board, i, j-1, visited);
		if(canCapture) {
			board[i][j] = 'X';
		}
		return canCapture;
	}
}
