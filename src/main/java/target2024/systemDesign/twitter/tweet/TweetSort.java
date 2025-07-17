package target2024.systemDesign.twitter.tweet;

import java.util.Comparator;

public class TweetSort implements Comparator<Tweet> {

	@Override
	public int compare(Tweet o1, Tweet o2) {
		return o1.getTimestamp().compareTo(o2.getTimestamp());
	}

}
