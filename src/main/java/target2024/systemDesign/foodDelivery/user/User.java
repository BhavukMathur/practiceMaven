package target2024.systemDesign.foodDelivery.user;

import lombok.Getter;

import java.util.UUID;

@Getter
public class User {
	String id;
	String name;
	String phoneNumber;
	String address;

	public User(String name, String phoneNumber) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
}
