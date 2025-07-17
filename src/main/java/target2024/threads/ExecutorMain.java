package target2024.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain implements Runnable {
	int ind;

	ExecutorMain(int ind) {
		this.ind = ind;
	}

	public static void main(String[] args) {
		ExecutorMain[] exarr = new ExecutorMain[5];
		ExecutorService executors = Executors.newFixedThreadPool(3);

		System.out.println("Main Thread Started");
		for(int i=0; i<5; i++) {
			exarr[i] = new ExecutorMain(i);
			executors.execute(exarr[i]);
		}
		System.out.println("Main Thread Completed");

		executors.shutdown();
//		while(!executors.isTerminated()) {
//			//infinite loop
//		}
	}

	@Override
	public void run() {
		System.out.println("Thread - " + ind + " Started");
		System.out.println("Thread - " + ind + " Completed");
	}
}
