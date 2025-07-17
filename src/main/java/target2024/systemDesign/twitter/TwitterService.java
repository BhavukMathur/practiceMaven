package target2024.systemDesign.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import target2024.systemDesign.twitter.tweet.Tweet;
import target2024.systemDesign.twitter.tweet.TweetSort;
import target2024.systemDesign.twitter.user.User;

//Design Pattern: Singleton
public class TwitterService {
	
	private static TwitterService instance;
	Map<String, User> userById;
	Map<String, List<Tweet>> tweetByUserId;
	
	private TwitterService() {
		userById = new HashMap<>();
		tweetByUserId = new HashMap<>();
	}
	
	public synchronized static TwitterService getInstance() {
		if(instance == null) {
			instance = new TwitterService();
		}
		return instance;
	}
	
	public User createUser(String name) {
		User user = new User(name); 		//Better to call User.create() from here
		userById.put(user.getId(), user);
		return user;
	}
	
	public void follow(User user1, User user2) { //user1 follows user2
		user1.getFollowing().add(user2.getId());
		user2.getFollowers().add(user1.getId());
	}
	
	public void tweet(User user, String content) {
		Tweet tweet = Tweet.createTweet(user.getId(), content);
		List<Tweet> list = tweetByUserId.getOrDefault(user.getId(), new LinkedList<Tweet>());
		list.add(tweet);
		tweetByUserId.put(user.getId(), list);
	}
	
	public List<Tweet> getTweets(User user) {
		return tweetByUserId.get(user.getId());
	}
	
	public void buildNewsFeed(User user) {
	    Set<String> following = user.getFollowing();
	    List<Tweet> allTweets = new LinkedList<>();

	    for (String userId : following) {
	        List<Tweet> tweets = tweetByUserId.getOrDefault(userId, Collections.emptyList());
	        allTweets.addAll(tweets);
	    }

	    Collections.sort(allTweets, new TweetSort());

	    for (Tweet tweet : allTweets) {
	        User tweetUser = userById.get(tweet.getUserId());
	        System.out.println(tweetUser.getName() + " : " + tweet.getContent());
	    }
	}
	
}
