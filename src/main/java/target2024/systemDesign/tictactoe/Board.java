package target2024.systemDesign.tictactoe;

public class Board {
	private final Integer BOARD_SIZE = 3;
	int maxTurns = BOARD_SIZE * BOARD_SIZE;
	Character[][] board;
	
	Board() {
		board = new Character[BOARD_SIZE][BOARD_SIZE];
//		for(int i=0; i<BOARD_SIZE; i++) {
//			for(int j=0; j<BOARD_SIZE; j++) {
//				board[i][j] = null;
//			}
//		}
	}
	
	public void printBoard() {
		for(int i=0; i<BOARD_SIZE; i++) {
			for(int j=0; j<BOARD_SIZE; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}
	}
	
}
