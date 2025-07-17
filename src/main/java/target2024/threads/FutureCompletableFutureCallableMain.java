package target2024.threads;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Future 
 * 	- Java5+ - Blocks via .get(). Has to be run via ExecutorService
 * CompletableFuture
 * 	- Java8+ - Non-blocking chaining: thenAccept, thenApply. Run via supplyAsync, runAsync
 */

public class FutureCompletableFutureCallableMain {
	public static void main(String[] args) {
//		runCFMultipleThreads();
		System.out.println(runFutureCallableSingleThread());
		System.out.println(runCFSingleThread());
		System.out.println(runFutureRunnableSingleThread());
	}
	
	@SneakyThrows
	private static int runFutureRunnableSingleThread() {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		AtomicInteger value = new AtomicInteger();
		
		Runnable runnableTask = () -> {
			value.set(300);
		};
		executor.submit(runnableTask); //No return type with runnable
		executor.shutdown();
		executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
		return value.get();
	}
	
	@SneakyThrows
	private static int runCFSingleThread() {
//		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
			int val = 10 * 10;
			try {
				Thread.sleep(1000);
				return val;
			} catch (Exception e) {
				return -1;
			}
		}); // ..,executor)
		
		CompletableFuture<Integer> newVal = cf.thenApply(result -> result + 100);
//		executor.shutdown();
		return newVal.get();
	}
	
	@SneakyThrows
	private static int runFutureCallableSingleThread() {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		Future<Integer> future = executor.submit(() -> {
			Thread.sleep(1000);
			return 10 * 10;
		});			
		int result = future.get();
		executor.shutdown();
		return result;
	}
	
	private static void runCFMultipleThreads() {
		int threadSize = 10;
		ExecutorService executor = Executors.newFixedThreadPool(threadSize/3);
		CompletableFuture[] futures = new CompletableFuture[threadSize];

		for(int i=0; i<threadSize; i++) {
			int finalI = i;
			futures[i] = CompletableFuture.runAsync(() -> {
				process(finalI);
			}, executor);
		}

		CompletableFuture.allOf(futures).thenRun(() -> {
			System.out.println("Operation completed");
			executor.shutdown();
		});
		
	}

	@SneakyThrows
	public static void process(int finalI) {
		System.out.println("Processing thread: " + finalI);
		Thread.sleep(1000);
	}
}
