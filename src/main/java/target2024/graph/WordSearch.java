package target2024.graph;

//https://leetcode.com/problems/word-search/description/
public class WordSearch {
	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}};

		String word = "ABCCEDF";

		System.out.println(checkIfWordExists(board, word));
	}

	private static boolean checkIfWordExists(char[][] board, String word) {
		for(int i=0; i < board.length; i++) {
			for (int j=0; j< board[0].length; j++) {
				String strSoFar = "";
				boolean visited[][] = new boolean[board.length][board[0].length];
				if(checkIfWordExistsRec(board, word, i, j, strSoFar, visited, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean checkIfWordExistsRec(
			char[][] board, String word, int i, int j, String strSoFar, boolean visited[][], int wordInd
	) {
		if(strSoFar.equals(word)) {
			return true;
		}
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return false;
		}
		if(strSoFar.length() > word.length()) {
			return false;
		}
		if(visited[i][j]) {
			return false;
		}

		visited[i][j] = true;
		String strSoFar1 = strSoFar + board[i][j];

		if(strSoFar1.charAt(wordInd) != word.charAt(wordInd)) {
			return false;
		}

		//Move in all directions
		boolean left = checkIfWordExistsRec(board, word, i, j-1, strSoFar1, visited, wordInd + 1);
		boolean right = checkIfWordExistsRec(board, word, i, j+1, strSoFar1, visited, wordInd + 1);
		boolean up = checkIfWordExistsRec(board, word, i-1, j, strSoFar1, visited, wordInd + 1);
		boolean down = checkIfWordExistsRec(board, word, i+1, j, strSoFar1, visited, wordInd + 1);

		visited[i][j] = false;
		return (left || right || up || down);
	}


}
