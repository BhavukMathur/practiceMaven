package target2024.systemDesign.tictactoe.game;

import java.util.Arrays;

import lombok.Getter;

@Getter
public class Board {
	int x, y;
	char[][] board;
	
	Board() {
		this(3);
	}
	
	Board(int size) {
		this.x = 3;
		this.y = 3;
		board = new char[size][size];
		for(int i=0; i<size; i++) {
			Arrays.fill(board[i], '-');
		}
	}
	
	public void printBoard() {
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void insertIntoBoard(int i, int j, char ch) {
		board[i][j] = ch;
	}
}
