package target2024.threads.cpuProcessor;

import lombok.Getter;

@Getter
public class ProcessLog {
	Long startTime;
	Long endTime;

	public ProcessLog(Long startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}
