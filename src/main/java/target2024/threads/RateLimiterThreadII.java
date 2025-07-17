package target2024.threads;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * Single server
 * Multiple clients trying to access it in multi-threaded way
 * Two methods - one will simply rateLimit based on client
 * another will put the waiting in a waiting queue
 * 
 */

class Server {
	private static Server instance;
	
	Integer maxCalls;
	ExecutorService executor;
	Object lock;
	
	private Server() {
		lock = new Object();
	}
	
	//Max 3 parallel calls possible 
	public void setRLConfig(int maxCalls) {
		this.maxCalls = maxCalls;
		executor = Executors.newFixedThreadPool(maxCalls);
	}
	
	public synchronized static Server getInstance() {
		if(instance == null) {
			instance = new Server();
		}
		return instance;
	}
	
	@SneakyThrows
	public void processWithWaitPool(Integer clientId) {
		executor.submit(() -> {
			process(clientId);
		});
	}
	
	@SneakyThrows
	private void process(Integer clientId) {
		System.out.println("Starting client: " + clientId);
		Thread.sleep(2000);
		System.out.println("-- Completed client: " + clientId);
	}
	
	public void shutDown() {
		executor.shutdown();
	}
}

public class RateLimiterThreadII {
	
	@SneakyThrows
	public static void main(String[] args) {
		Server server = Server.getInstance();
		
		server.setRLConfig(2);
		
		int clientSize = 10;

		Thread[] tarr = new Thread[clientSize];

		for(int i=0; i<clientSize; i++) {
			final int finalI = i;
			tarr[i] = new Thread(new Runnable() {
				public void run() {
					server.processWithWaitPool(finalI);
				}
			});
		}
		
		for(int i=0; i<clientSize; i++) {
			tarr[i].start();
		}
		
		for(int i=0; i<clientSize; i++) {
			tarr[i].join(); 				//Waits for all threads to complete
		}
		
		server.shutDown();
	}

}
