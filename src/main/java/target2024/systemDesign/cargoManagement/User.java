package target2024.systemDesign.cargoManagement;

import lombok.Getter;

@Getter
public class User {
	String id;
	String name;
	
	private User(String name) {
		this.name = name;
	}
	
	public static User createUser(String name) {
		return new User(name);
	}
}
