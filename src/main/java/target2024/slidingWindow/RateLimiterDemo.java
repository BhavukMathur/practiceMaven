package target2024.slidingWindow;

import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Input: [1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 7, 11, 11, 11, 11, 11]
 * HashMap: [0-0, 1-4, 2-3, 3-3, 4-2, 5-2, 6-4, 7-3, 11-5]
 * Index and Cumulative Array:
 * [0, 1, 2, 03, 04, 05, 06, 07, 08, 09, 10, 11]
 * [0, 4, 7, 10, 12, 14, 18, 21, 21, 21, 21, 26]
 * Max 3 requests in 1 second
 * Max 20 requests in 10seconds
 * Max 60 requests in 60 seconds
 */

class RateLimiter {

	Map<Integer, Integer> rlConfig;

	RateLimiter() {
		rlConfig = new HashMap<>();
	}

	public void updateRLConfig(int maxRequests, int window) {
		rlConfig.put(maxRequests, window);
	}

	public int droppedRequests(List<Integer> requestTime) {
		int result = 0;
		Set<Integer> droppedIndexes = new HashSet<>();

		// * Input: [1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 7, 11, 11, 11, 11, 11]
		// * HashMap: [0-0, 1-4, 2-3, 3-3, 4-2, 5-2, 6-4, 7-3, 11-5]
		// * Index and Cumulative Array:
		// * [0, 1, 2, 03, 04, 05, 06, 07, 08, 09, 10, 11]
		// * [0, 4, 7, 10, 12, 14, 18, 21, 21, 21, 21, 26]

		Map<Integer, Integer> countByTimeStamp = new HashMap<>();
		for(Integer val: requestTime) {
			countByTimeStamp.put(val, countByTimeStamp.getOrDefault(val, 0) + 1);
		}
		System.out.println(countByTimeStamp);

		int maxTime = requestTime.get(requestTime.size()-1);
		int[] cumulativeRequest = new int[maxTime + 1];
		Arrays.fill(cumulativeRequest, 0);

		for(int i=1; i<maxTime+1; i++) {
			cumulativeRequest[i] = cumulativeRequest[i-1] + countByTimeStamp.getOrDefault(i, 0);
		}
		System.out.println(Arrays.toString(cumulativeRequest));

		for(Map.Entry<Integer, Integer> entry: rlConfig.entrySet()) {
			int maxRequests = entry.getKey();
			int window = entry.getValue();

			int j = 1;

			while(j < cumulativeRequest.length) {
				int i = (j - window) < 0 ? 0: (j - window);
//				System.out.println(j + " : " + i);

				if(cumulativeRequest[j] - cumulativeRequest[i] > maxRequests) {
					droppedIndexes.add(j);
					System.out.println("Rate limiting index : " + j + ". Failed window : " + entry);
				}
				j++;
			}
//			System.out.println();
		}

		return droppedIndexes.size();
	}
}

public class RateLimiterDemo {
	public static void main(String[] args) {
		RateLimiter rl = new RateLimiter();
		rl.updateRLConfig(3, 1);
		rl.updateRLConfig(20, 10);
		rl.updateRLConfig(60, 60);

		List<Integer> requestTime = new LinkedList<>(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 7, 11, 11, 11, 11, 11));

		System.out.println(rl.droppedRequests(requestTime));
	}
}
