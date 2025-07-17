package target2024.threads;

import lombok.SneakyThrows;

class ThreadNumber implements Runnable {
	static int MAX_VAL = 25;
	static int count = 1;
	static int total = 3;
	int remainder;
	static Object lock = new Object();

	ThreadNumber(int remainder) {
		this.remainder = remainder;
	}

	@SneakyThrows
	public void run() {
		while(count <= MAX_VAL) {
			synchronized (lock) {
				while((count % total) != remainder) {
					lock.wait();
				}
				System.out.println(Thread.currentThread().getName() + "-->" + count);
				count++;
				lock.notifyAll();
			}
			Thread.sleep(1000);
		}
	}
}

public class ThreadNumberOrderMain {
	public static void main(String[] args) {
		int threadNum = 3;
		Thread[] tarr = new Thread[threadNum];

		for(int i=0; i<threadNum; i++) {
			tarr[i] = new Thread(new ThreadNumber((i+1)%threadNum));
			tarr[i].setName("T" + (i+1));
		}

		for(int i=0; i<threadNum; i++) {
			tarr[i].start();
		}
	}
}
