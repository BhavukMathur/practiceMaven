package target2024.systemDesign.elevator;

public class ElevatorDemo {
	public static void main(String[] args) throws Exception {
		ElevatorManager em = ElevatorManager.getInstance();
		em.registerElevators(3);

		em.initializeElevators();

		Elevator e1 = em.getElevator(new Request(5, 10));
		Thread.sleep(100);
		Elevator e2 = em.getElevator(new Request(6, 9));
		Thread.sleep(100);
		Elevator e3 = em.getElevator(new Request(9, 10));
//		Elevator e4 = em.getElevator(new Request(5, 10));
//		Elevator e5 = em.getElevator(new Request(5, 10));
	}
}
