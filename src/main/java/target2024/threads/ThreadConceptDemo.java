package target2024.threads;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Static - stored in shared memory of class
 * Instance - Heap memory of the instance/object
 */
public class ThreadConceptDemo {
	private static int counterWithIssue = 0;
	private static int counterThreadSafe = 0;
	private volatile static int counterThreadSafeVolatile = 0;

	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	private static synchronized void incrementCounterThreadSafe() {
		counterThreadSafe++;
	}

	@SneakyThrows
	public static void main(String[] args) {
		Thread threadA = new Thread(() -> {
			for(int i=0; i<10000; i++) {
				counterWithIssue++;
				counterThreadSafeVolatile++;
				atomicInteger.incrementAndGet();
				incrementCounterThreadSafe();
			}
		});

		Thread threadB = new Thread(() -> {
			for(int i=0; i<10000; i++) {
				counterWithIssue++;
				counterThreadSafeVolatile++;
				atomicInteger.incrementAndGet();
				incrementCounterThreadSafe();
			}
		});

		threadA.start();
		threadB.start();

		threadA.join();
		threadB.join();

		System.out.println("Counter value = " + counterWithIssue);
		System.out.println("Volatile Counter value = " + counterThreadSafeVolatile);
		System.out.println("Counter value = " + counterThreadSafe);
		System.out.println("Atomic Counter value = " + atomicInteger.get());
	}
}
