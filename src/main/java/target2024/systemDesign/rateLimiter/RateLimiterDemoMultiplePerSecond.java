package target2024.systemDesign.rateLimiter;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Separate Deques per rate limit window
 */
class RateLimiterMultiplePerSecond {
	
	Map<Integer, Integer> rlConfig;
	Map<Integer, Deque<Integer>> rlWindowQueues;
	final String SUCCESS_RESPONSE = "success";
	final String FAILURE_RESPONSE = "rateLimited";
	
	RateLimiterMultiplePerSecond() {
		rlConfig = new HashMap<>();
		rlWindowQueues = new HashMap<>();
	}
	
	public void updateRateLimitConfig(int maxCalls, int window) {
		rlConfig.put(maxCalls, window);
		rlWindowQueues.put(window, new LinkedList<>());
	}
	
	public List<String> processWithRateLimit(int[] arr) {
		List<String> result = new LinkedList<>();
		
		
		for(int i=0; i<arr.length; i++) {
			boolean isRateLimited = false;
			int currentTime = arr[i];
			for(Map.Entry<Integer, Integer> entry: rlConfig.entrySet()) {
				int maxCalls = entry.getKey();
				int window = entry.getValue();
				
				Deque<Integer> deque = rlWindowQueues.get(window);
				
				//Remove obsolete requests
				while(!deque.isEmpty() && deque.peek() <= (currentTime - window)) {
					deque.poll();
				}
				
				if(deque.size() >= maxCalls) {
					isRateLimited = true;
				}
				
				deque.add(currentTime);
			}

			if(isRateLimited) {
				result.add(FAILURE_RESPONSE);
			} else {
				result.add(SUCCESS_RESPONSE);
			}
		}
		
		
		return result;
	}
}

public class RateLimiterDemoMultiplePerSecond {

	public static void main(String[] args) {
		int[] arr = {0, 1, 1, 2, 3, 16, 16, 19, 19};
		
		RateLimiterMultiplePerSecond rateLimiter = new RateLimiterMultiplePerSecond();
		
		rateLimiter.updateRateLimitConfig(3, 5);
		rateLimiter.updateRateLimitConfig(5, 10);
		
		
		List<String> results = rateLimiter.processWithRateLimit(arr);
		
		results.forEach(result -> {
			System.out.println(result);
		});
	}

}
