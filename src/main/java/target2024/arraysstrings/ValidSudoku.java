package target2024.arraysstrings;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150
public class ValidSudoku {
	public static void main(String[] args) {
		char[][] sudoku = {{'8','3','.','.','7','.','.','.','.'}
				,{'6','.','.','1','9','5','.','.','.'}
				,{'.','9','8','.','.','.','.','6','.'}
				,{'8','.','.','.','6','.','.','.','3'}
				,{'4','.','.','8','.','3','.','.','1'}
				,{'7','.','.','.','2','.','.','.','6'}
				,{'.','6','.','.','.','.','2','8','.'}
				,{'.','.','.','4','1','9','.','.','5'}
				,{'.','.','.','.','8','.','.','7','9'}};

		ValidSudoku vs = new ValidSudoku();
		System.out.println(vs.isValidSudoku(sudoku));
	}

	public boolean isValidSudoku(char[][] board) {
		int size = 9;
		char ch;
		Set<Character>[] rowHash = new HashSet[size];
		Set<Character>[] colHash = new HashSet[size];
		Set<Character>[] gridHash = new HashSet[size];

		for(int i=0; i<size; i++) {
			rowHash[i] = new HashSet();
			colHash[i] = new HashSet();
			gridHash[i] = new HashSet();
		}

		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				ch = board[i][j];
				if(ch == '.') {
					//Do nothing
				} else if (ch >='0' && ch <='9') {
					//Validate for row
					if(rowHash[i].contains(ch)) {
						return false;
					}
					rowHash[i].add(ch);

					//Validate for col
					if(colHash[j].contains(ch)) {
						return false;
					}
					colHash[j].add(ch);

					//Validate for grid
					if(gridHash[3*(i/3) + (j/3)].contains(ch)) {
						return false;
					}
					gridHash[3*(i/3) + (j/3)].add(ch);
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
