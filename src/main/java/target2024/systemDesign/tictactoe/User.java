package target2024.systemDesign.tictactoe;

import java.util.UUID;

import lombok.Getter;

@Getter
public class User {
	String id;
	String name;
	
	User(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
	}
	
}
