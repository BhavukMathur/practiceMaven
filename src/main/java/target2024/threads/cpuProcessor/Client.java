package target2024.threads.cpuProcessor;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Client {
	Integer id;
	Integer priority;

	@SneakyThrows
	public void process() {
		System.out.println(id + " is processed");
		Thread.sleep(1000);
	}
}
