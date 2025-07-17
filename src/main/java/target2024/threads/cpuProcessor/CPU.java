package target2024.threads.cpuProcessor;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.Queue;

//Singleton design pattern
public class CPU {
	private static CPU instance;
	private final Integer MAX_THREAD_POOL = 3;
	Object lock = new Object();

	static Queue<Client> executingThreadPool;
	static Queue<Client> waitingThreadPool;

	private CPU() {
		executingThreadPool = new LinkedList<>();
		waitingThreadPool = new LinkedList<>();
	}

	public synchronized static CPU getInstance() {
		if(instance == null) {
			instance = new CPU();
		}
		return instance;
	}

	@SneakyThrows
	public void execute(Client client) {
//		System.out.println("Received client=" + client.id);
		waitingThreadPool.add(client);
		synchronized (lock) {
			if(executingThreadPool.size() <= MAX_THREAD_POOL) {
				executingThreadPool.add(waitingThreadPool.poll());
			} else {
				lock.wait();
				executingThreadPool.add(waitingThreadPool.poll());
			}
		}

		Client clientToProcess;
		synchronized (lock) {
			clientToProcess = executingThreadPool.poll();
		}
		process(clientToProcess);

		synchronized (lock) {
			lock.notifyAll();
		}
	}

	@SneakyThrows
	public void process(Client client) {
		System.out.println("-----Executing client=" + client.id);
	}
}
