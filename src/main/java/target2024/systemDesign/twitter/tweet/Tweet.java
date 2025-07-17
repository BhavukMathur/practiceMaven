package target2024.systemDesign.twitter.tweet;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;

@Getter
public class Tweet {
	String id;
	String userId;
	String content;
	LocalDateTime timestamp;
	
	Tweet(String userId, String content) {
		this.id = UUID.randomUUID().toString();
		this.userId = userId;
		this.content = content;
		this.timestamp = LocalDateTime.now();
	}
	
	public static Tweet createTweet(String userId, String content) {
		return new Tweet(userId, content);
	}
}
