package target2024.systemDesign.rateLimiter;

import lombok.Setter;
import lombok.SneakyThrows;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class RateLimiterFixedII {
	Deque<Long> deque;

	Map<Integer, Integer> rlWindow;

	RateLimiterFixedII() {
		deque = new LinkedList<Long>();
		rlWindow = new HashMap<>();
	}

	public void addConfig(int maxRequests, int window) {
		rlWindow.put(maxRequests, window);
	}

	//Currently, not thread-safe. This is for fixed input given as a list
	public void process(int i) {
		long now = System.currentTimeMillis();

		for(Map.Entry<Integer, Integer> entry: rlWindow.entrySet()) {
			long windowStart = now - entry.getValue(); //Iterate over the map
			int maxRequests = entry.getKey();

			//Remove obsolete requests
			while(!deque.isEmpty() && (deque.peekFirst() < windowStart)) {
				deque.pollFirst();
			}

			if(deque.size() < maxRequests) {
				deque.add(now);	//Adding the request
				System.out.println("Request " + i + " processed successfully");
			} else {
				System.out.println("Rate Limited " + i);
			}
		}
	}
}

public class RateLimiterFixedIIDemo {
	@SneakyThrows
	public static void main(String[] args) {
		RateLimiterFixedII rl2 = new RateLimiterFixedII();
		int size = 15;
		rl2.addConfig(3, 5000);

		for(int i=0; i<size; i++) {
			rl2.process(i);
			Thread.sleep(1000);
		}
	}
}
