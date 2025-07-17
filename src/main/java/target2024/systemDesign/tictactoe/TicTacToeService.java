package target2024.systemDesign.tictactoe;

import target2024.systemDesign.tictactoe.game.Game;

//Design Pattern: Singleton Pattern
public class TicTacToeService {
	private static TicTacToeService instance;
	Board board;
	Game game;
	
	private TicTacToeService() {
		
	}
	
	public static synchronized TicTacToeService getInstance() {
		if(instance == null) {
			instance = new TicTacToeService();
		}
		return instance;
	}
	
	public User createUser(String name) {
		return User.createUser(name);
	}
	
	private Board createBoard() {
		Board board = new Board();
		this.board = board;
		return board;
	}
	
	
	public Game createGame(User user1, User user2) {
		Board board = createBoard();
		Game game = new Game(user1, user2, board);
		this.game = game;
		return game;
	}
	
	public void play() {
		
	}
}
