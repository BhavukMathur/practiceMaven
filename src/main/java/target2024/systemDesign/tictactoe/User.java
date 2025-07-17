package target2024.systemDesign.tictactoe;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
public class User {
	String id;
	String name;
	@Setter
	Character ch;
	
	User(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
	}
	
	public static User createUser(String name) {
		return new User(name);
	}
}
