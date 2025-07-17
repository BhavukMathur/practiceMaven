package target2024.systemDesign.hotelBooking.user;

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
	
	public static User createUser(String name) {
		return new User(name);
	}
}
