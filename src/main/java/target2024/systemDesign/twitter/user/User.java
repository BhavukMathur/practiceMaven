package target2024.systemDesign.twitter.user;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import lombok.Getter;

@Getter
public class User {
	String id;
	String name;
	
	Set<String> followers; //People following this user
	Set<String> following; //People being followed
	
	public User(String name) {
		this.id  = UUID.randomUUID().toString();
		this.name = name;
		followers = new HashSet<>();
		following = new HashSet<>();
	}
	
	
}
