package target2024.systemDesign.rateLimiter;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Multiple rate limiters
 * 	- max 3 calls in 5 seconds
 * 	- max 5 calls in 10 seconds
 */
class RateLimit {

	private Map<Integer, Integer> rateLimitConfig;
	private Map<String, Deque<Integer>> logByDomain;
	private String SUCCESS_RESPONSE = "status:200 OK";
	private String FAILURE_RESPONSE = "status:429 RATE-LIMITED";

	RateLimit() {
		rateLimitConfig = new HashMap<>();
		logByDomain = new HashMap<>();
	}

	protected void setRateLimit(int limit, int window) {
		rateLimitConfig.put(limit, window);
	}
	
	protected List<String> validateForRateLimit(List<String> inputDomains) {
		List<String> result = new LinkedList<>();

		for(int i=0; i<inputDomains.size(); i++) {
			if(isRequestAllowed(inputDomains, i)) {
				result.add(SUCCESS_RESPONSE);
			} else {
				result.add(FAILURE_RESPONSE);
			}
		}
		return result;
	}

	private Boolean isRequestAllowed(List<String> inputDomains, int ind) {
		String domain = inputDomains.get(ind);
		if(logByDomain.get(domain) == null) {
			Deque<Integer> dq = new LinkedList<>();
			dq.add(ind);
			logByDomain.put(domain, dq);
			return true;
		} else {
			Deque dq = logByDomain.get(domain);

			//Validate against each rateLimit config
			for(Map.Entry<Integer, Integer> config: rateLimitConfig.entrySet()) {
				int limit = config.getKey();
				int window = config.getValue();

				int leftIndex = (ind - window) < 0 ? 0 : (ind - window);

				int count = 0;
				for(int i=leftIndex; i <= ind; i++) {
					if(inputDomains.get(i).equals(domain)) {
						count++;
					}
				}
				if(count > limit) {
					return false;
				}
			}
		}
		return true;
	}
}

public class RateLimiterDemoDomains {
	public static void main(String[] args) {
		List<String> inputDomains = new LinkedList<>();

		RateLimit rl = new RateLimit();
		rl.setRateLimit(2, 5);
		rl.setRateLimit(3, 10);

		inputDomains.add("www.abc.com");
		inputDomains.add("www.xyz.com");
		inputDomains.add("www.abc.com");
		inputDomains.add("www.xyz.com");
		inputDomains.add("www.xyz.com");
		inputDomains.add("www.pqr.com");
		inputDomains.add("www.abc.com");
		inputDomains.add("www.lmn.com");
		inputDomains.add("www.xyz.com");
		inputDomains.add("www.xyz.com");
		inputDomains.add("www.xyz.com");
		inputDomains.add("www.xyz.com");
		inputDomains.add("www.xyz.com");
		inputDomains.add("www.abc.com");
		inputDomains.add("www.pqr.com");

		List<String> results = rl.validateForRateLimit(inputDomains);

		for(int i=0; i<inputDomains.size(); i++) {
			System.out.println(inputDomains.get(i) + " : " + results.get(i));
		}
	}

}
