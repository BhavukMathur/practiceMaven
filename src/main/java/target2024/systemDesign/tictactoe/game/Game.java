package target2024.systemDesign.tictactoe.game;

import java.util.Scanner;

import target2024.systemDesign.tictactoe.Board;
import target2024.systemDesign.tictactoe.User;

public class Game {
	User user1;
	User user2;
	User currentPlayer;
	Board board;
	GameStatus status;
	
	public Game(User user1, User user2, Board board) {
		this.user1 = user1;
		this.user2 = user2;
		this.board = board;
		this.status = GameStatus.NEW;
		this.currentPlayer = user1;
	}
	
	public void play() {
	    Scanner scanner = new Scanner(System.in);
	    this.status = GameStatus.IN_PROGRESS;
	    User currentPlayer = user1;

	    //TODO
	    while (status == GameStatus.IN_PROGRESS) {
	        board.printBoard();
	        System.out.println("Current player: " + currentPlayer.getName() + " (" + currentPlayer.getCh() + ")");
	        System.out.print("Enter row and column (0, 1, 2): ");
	        
	        int row = scanner.nextInt();
	        int col = scanner.nextInt();
	        
	        this.currentPlayer = currentPlayer == user1 ? user2 : user1; 		//Toggle between users
	    }
	}

}
