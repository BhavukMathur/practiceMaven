package target2024.systemDesign.tictactoe;

import target2024.systemDesign.tictactoe.game.Game;

public class TicTacToeDemo {

	public static void main(String[] args) {
		TicTacToeService service = TicTacToeService.getInstance();
		
		User user1 = service.createUser("user1");
		user1.setCh('X');
		User user2 = service.createUser("user2");
		user2.setCh('O');
		
		Game game = service.createGame(user1, user2);
		
		service.play();
	}

}
