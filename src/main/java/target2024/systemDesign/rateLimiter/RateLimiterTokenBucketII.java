package target2024.systemDesign.rateLimiter;

import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

class TokenBucketRateLimiter {
    private final int capacity;
    private final int refillRatePerSecond;
    private double availableTokens;
    private long lastRefillTimestamp;

    public TokenBucketRateLimiter(int capacity, int refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.availableTokens = capacity;
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refill();

        if (availableTokens >= 1) {
            availableTokens -= 1;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        long elapsedTime = now - lastRefillTimestamp;

        double tokensToAdd = (elapsedTime / 1_000_000_000.0) * refillRatePerSecond;
        if (tokensToAdd > 0) {
            availableTokens = Math.min(capacity, availableTokens + tokensToAdd);
            lastRefillTimestamp = now;
        }
    }
}


public class RateLimiterTokenBucketII {

	@SneakyThrows
	public static void main(String[] args) {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5, 2); // 2 tokens/sec, max 5 tokens

        for (int i = 0; i < 10; i++) {
            boolean allowed = limiter.allowRequest();
            System.out.println("Request " + i + " allowed: " + allowed);
            Thread.sleep(300); // simulate 300ms delay between requests
        }
    }

}
