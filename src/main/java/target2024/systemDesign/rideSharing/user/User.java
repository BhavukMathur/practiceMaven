package target2024.systemDesign.rideSharing.user;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class User {
	String id;
	String name;
	String phone;

	public User(String name, String phone) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.phone = phone;
	}
}
