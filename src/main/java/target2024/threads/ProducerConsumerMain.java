package target2024.threads;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.Queue;

/**
 * synchronized (lock) --> acquires the lock
 * lock.wait() --> puts the thread in waiting state
 * lock.wait() --> releases the lock
 */
class PC {
	static Queue<Integer> pool = new LinkedList<>();
	int MAX_POOL_SIZE = 3;
	static Object lock = new Object();

	@SneakyThrows
	public void produce() {
		while(true) {
			synchronized (lock) {
				while(pool.size() == MAX_POOL_SIZE) {
					lock.wait();
				}

				int temp = (int)(Math.random() * 100);
				pool.add(temp);
				System.out.println("Thread = " + Thread.currentThread().getName() + " Produced = " + temp);
				lock.notifyAll();
			}
		}
	}

	@SneakyThrows
	public void consume() {
		while(true) {
			synchronized (lock) {
				while(pool.size() == 0) {
					lock.wait();
				}

				int temp = pool.poll();
				System.out.println("Thread = " + Thread.currentThread().getName() + " Consumed = " + temp);
				lock.notify();
			}
			Thread.sleep(1000);
		}
	}
}

public class ProducerConsumerMain {
	public static void main(String[] args) {
		PC pc = new PC();

		//Creating Producer
		Thread producer = new Thread(new Runnable() {
			public void run() { pc.produce(); }
		});
		producer.setName("Producer");

		//Creating Consumer
		int consumerSize = 3;
		Thread[] tcarr = new Thread[consumerSize];

		//Anonymous inner class
		for(int i=0; i<consumerSize; i++) {
			tcarr[i] = new Thread(new Runnable() {
				public void run() {
					pc.consume();
				}
			});
			tcarr[i].setName("C-" + i);
		}

		//Starting Producer and Consumer
		producer.start();
		for(int i=0; i<consumerSize; i++) {
			tcarr[i].start();
		}
	}
}
