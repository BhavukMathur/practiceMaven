package target2024.threads.cpuProcessor;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CPUExecutor {
	private static CPUExecutor instance;
	private final Integer MAX_THREAD_POOL = 3;
	Map<Client, ProcessLog> logByClient;

	private ExecutorService executor;

	private CPUExecutor() {
		executor = Executors.newFixedThreadPool(MAX_THREAD_POOL);
		logByClient = new HashMap();
	}

	public void execute(Client client) {
		updateLog(client, LogEnum.START);
		executor.submit(() -> {
			// Call client's callback or processing method here
			client.process();
			updateLog(client, LogEnum.END);
		});
	}

	private void updateLog(Client client, LogEnum logEnum) {
		if(logEnum == LogEnum.START) {
			logByClient.put(client, new ProcessLog(System.currentTimeMillis()));
		} else {
			ProcessLog log = logByClient.get(client);
			log.setEndTime(System.currentTimeMillis());
		}
	}

	@SneakyThrows
	public void shutdown() {
		// Initiate shutdown and await termination of all threads
		executor.shutdown();
		if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
			executor.shutdownNow();
		}
	}

	public synchronized static CPUExecutor getInstance() {
		if(instance == null) {
			instance = new CPUExecutor();
		}
		return instance;
	}

	public void printLogTime() {
		for(Map.Entry<Client, ProcessLog> entry: logByClient.entrySet()) {
			System.out.println("Client - " + entry.getKey().id + " - "
					+ (entry.getValue().endTime - entry.getValue().startTime));
		}
	}
}
