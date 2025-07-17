package target2024.threads;

import lombok.SneakyThrows;

class RateLimiter {
	static int requestCount = 0;
	int MAX_BUCKET_SIZE = 5;
	static Object lock = new Object();

	@SneakyThrows
	public void request(int ind) {
		synchronized (lock) {
			if (requestCount >= MAX_BUCKET_SIZE) {
				reject(ind);
				return;
			}
			requestCount++;
		}
		process(ind);
		synchronized (lock) {
			requestCount--;
			lock.notifyAll();
		}
	}


	@SneakyThrows
	private void process(int ind) {
		System.out.println("Processing request=" + ind);
		Thread.sleep(10);
	}

	private void reject(int ind) {
		System.out.println("Rejecting request=" + ind);
	}
}

public class RateLimiterDemo {
	@SneakyThrows
	public static void main(String[] args) {
		RateLimiterDemo rld = new RateLimiterDemo();
		rld.testRateLimit();
	}

	public void testRateLimit() {
		RateLimiter rl = new RateLimiter();

		int clientSize = 40;
		Thread[] tClient = new Thread[clientSize];

		for(int i=0; i<clientSize; i++) {
			final int finalI = i;
			tClient[i] = new Thread(new Runnable() {
				@Override
				@SneakyThrows
				public void run() {
					rl.request(finalI);
				}
			});
		}

		for(int i=0; i<clientSize; i++) {
			tClient[i].start();
		}
	}
}
