package target2024.systemDesign.tictactoe;

import target2024.systemDesign.tictactoe.game.Game;

public class TicTacToeDemo {

	public static void main(String[] args) {
		TicTacToeService service = TicTacToeService.getInstance();
		User user1 = service.createUser("user1");
		User user2 = service.createUser("user2");
		
		Game game = service.createGame(user1, user2);
		
		game.getBoard().printBoard();
		
		service.play(game);
	}

}
