package target2024.systemDesign.twitter;

import java.util.List;

import target2024.systemDesign.twitter.tweet.Tweet;
import target2024.systemDesign.twitter.user.User;

public class TwitterDemo {

	public static void main(String[] args) {
		TwitterService service = TwitterService.getInstance();
		
		User user1 = service.createUser("user1");
		User user2 = service.createUser("user2");
		User user3 = service.createUser("user3");
		
		service.follow(user1, user2);
		service.follow(user1, user3);
		
		service.tweet(user2, "Good morning");
		service.tweet(user3, "Sun looks bright..!!");
		service.tweet(user2, "Good night folks..!");
		
		List<Tweet> list = service.getTweets(user2);
		list.forEach(tweet -> {
			System.out.println(tweet.getUserId() + " : " + tweet.getContent());
		});
		
		service.buildNewsFeed(user1);
	}

}
