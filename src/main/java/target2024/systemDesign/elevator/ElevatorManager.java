package target2024.systemDesign.elevator;

import java.util.ArrayList;
import java.util.List;

//Singleton desgin pattern
public class ElevatorManager {
	private static ElevatorManager instance;
	List<Elevator> elevators;

	private ElevatorManager() {
		elevators = new ArrayList<>();
	}

	public synchronized static ElevatorManager getInstance() {
		if(instance == null) {
			instance = new ElevatorManager();
		}
		return instance;
	}

	public void registerElevators(int count) {
		for(int i=0; i<count; i++) {
			Elevator elevator = new Elevator("Elevator" + i);
			elevators.add(elevator);
		}
	}

	public void initializeElevators() {
		Thread[] tarr = new Thread[elevators.size()];

		for(int i=0; i<elevators.size(); i++) {
			int finalI = i;
			tarr[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					elevators.get(finalI).processRequest();
				}
			});
		}

		for(int i=0; i<elevators.size(); i++) {
			tarr[i].start();
		}
	}

	public Elevator getElevator(Request request) {
		Direction reqDirection = request.currentFloor < request.destFloor ? Direction.UP : Direction.DOWN;

		//Request for going up
		if(reqDirection == Direction.UP) {
			for(Elevator elevator: elevators) {
				if((elevator.currentFloor < request.currentFloor
						&& (elevator.direction == Direction.UP)) || elevator.direction == Direction.IDLE) {
					elevator.addRequest(request);
					System.out.println("Elevator found = " + elevator.id);
					return elevator;
				}
			}
		} else {
			for(Elevator elevator: elevators) {
				if((elevator.currentFloor > request.currentFloor
						&& (elevator.direction == Direction.DOWN)) || elevator.direction == Direction.IDLE) {
					elevator.addRequest(request);
					System.out.println("Elevator found = " + elevator.id);
					return elevator;
				}
			}
		}
		return elevators.get((int) (Math.random() * elevators.size()));
	}
}
