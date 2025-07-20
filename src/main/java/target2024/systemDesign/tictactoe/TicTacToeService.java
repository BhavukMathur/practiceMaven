package target2024.systemDesign.tictactoe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import target2024.systemDesign.tictactoe.game.Board;
import target2024.systemDesign.tictactoe.game.Game;
import target2024.systemDesign.tictactoe.game.GameStatus;

//Singleton Design Pattern
public class TicTacToeService {
	private static TicTacToeService instance;
	private Map<String, Game> gameMap;
	
	private TicTacToeService() {
		gameMap = new HashMap<>();
	}
	
	public synchronized static TicTacToeService getInstance() {
		if(instance == null) {
			instance = new TicTacToeService();
		}
		return instance;
	}
	
	public User createUser(String name) {
		User user = new User(name);
		return user;
	}
	
	public Game createGame(User user1, User user2) {
		Game game = new Game(user1, user2);
		this.gameMap.put(game.getId(), game);
		return game;
	}
	
	public void play(Game game) {
        Scanner scanner = new Scanner(System.in);
        int i,j, turnCount=0;
		while(game.getStatus() == GameStatus.IN_PROGRESS) {
			turnCount++;
			User currentUser = game.getCurrentUser();
			Character currentSymbol = game.getCurrentSymbol();
		    System.out.println("Enter value for i, j");
		    i = scanner.nextInt();
	        j = scanner.nextInt();
	        
	        game.getBoard().insertIntoBoard(i, j, currentSymbol);
	        game.getBoard().printBoard();
	        
	        if(isGameOver(game.getBoard(), currentSymbol, i, j)) {
	        	game.setStatus(GameStatus.COMPLETE);
	        	System.out.println("Winner is : " + currentUser.getName());
	        	return;
	        }
	        if(turnCount == game.getBoard().getX() * game.getBoard().getY()) {
	        	game.setStatus(GameStatus.DRAW);
	        	System.out.println("Game drawn");
	        	return;
	        }
	        game.toggleCurrentTurn();
		}
	}
	
	private boolean isGameOver(Board board, Character symbol, int x, int y) {
	    char[][] boardArr = board.getBoard();
	    
	    //Check row
	    if(boardArr[x][0] == symbol && boardArr[x][1] == symbol && boardArr[x][2] == symbol) {
	    	return true;
	    }

	    //Check column
	    if(boardArr[0][y] == symbol && boardArr[1][y] == symbol && boardArr[2][y] == symbol) {
	    	return true;
	    }
	    
	    //Check left diagonal
	    if(boardArr[0][0] == symbol && boardArr[1][1] == symbol && boardArr[2][2] == symbol) {
	    	return true;
	    }
	    
	    //Check right diagonal
	    if(boardArr[2][0] == symbol && boardArr[1][1] == symbol && boardArr[0][2] == symbol) {
	    	return true;
	    }

	    return false;
	}
}
