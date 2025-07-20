package target2024.systemDesign.tictactoe.game;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import target2024.systemDesign.tictactoe.User;

@Getter
public class Game {
	String id;
	Board board;
	User xUser;
	User oUser;
	User currentUser;
	Character currentSymbol;
	@Setter
	GameStatus status;
	
	public Game(User xUser, User oUser) {
		this.id = UUID.randomUUID().toString();
		this.board = new Board();
		this.xUser = xUser;
		this.oUser = oUser;
		this.currentUser = xUser;
		this.currentSymbol = 'X'; 
		this.status = GameStatus.IN_PROGRESS;
	}
	
	public void toggleCurrentTurn() {
		if(currentSymbol == 'X') {
			currentSymbol = 'O';
			currentUser = oUser;
		} else {
			currentSymbol = 'X';
			currentUser = xUser;
		}
	} 
}
