package target2024.threads.cpuProcessor;

import lombok.SneakyThrows;

public class CPUDemo {
	@SneakyThrows
	public static void main(String[] args) {
//		CPU cpu = CPU.getInstance();
		CPUExecutor cpu = CPUExecutor.getInstance();

		int clientSize = 10;
		Client[] carr = new Client[clientSize];

		//Create clients
		for(int i=0; i<clientSize; i++) {
			carr[i] = new Client(i, i);
		}

		for(int i=0; i<clientSize; i++) {
			cpu.execute(carr[i]);
		}

		cpu.shutdown();

		//Printing the logs
		cpu.printLogTime();

//		Thread[] tarr = new Thread[clientSize];
//
//		//Create threads
//		for(int i=0; i<clientSize; i++) {
//			int finalI = i;
//			tarr[i] = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					cpu.execute(carr[finalI]);
//				}
//			});
//		}
//
//		//Initialize threads
//		for(int i=0; i<clientSize; i++) {
//			tarr[i].start();
//		}
	}
}
