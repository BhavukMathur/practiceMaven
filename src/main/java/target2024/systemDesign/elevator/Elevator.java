package target2024.systemDesign.elevator;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
	String id;
	Integer currentFloor;
	Direction direction;
	Queue<Request> requests;

	Elevator(String id) {
		this.id = id;
		this.currentFloor = 0;
		this.direction = Direction.IDLE;
		requests = new LinkedList<>();
	}

	@SneakyThrows
	public synchronized void processRequest() {
		while(true) {
			while(!requests.isEmpty()) {
				Request request = requests.poll();
				System.out.println(this.id + " moving from " + this.currentFloor + " to " + request.destFloor);
				this.currentFloor = request.destFloor;
				if(request.destFloor > request.currentFloor) {
					this.direction = Direction.UP;
				} else {
					this.direction = Direction.DOWN;
				}
			}
			wait();
		}
	}

	public synchronized void addRequest(Request request) {
		requests.add(request);
		notifyAll();
	}
}
