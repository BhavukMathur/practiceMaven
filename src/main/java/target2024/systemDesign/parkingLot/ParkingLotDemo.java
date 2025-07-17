package target2024.systemDesign.parkingLot;

import target2024.systemDesign.parkingLot.fees.VehicleBasedFeeStrategy;
import target2024.systemDesign.parkingLot.vehicle.Bike;
import target2024.systemDesign.parkingLot.vehicle.Car;
import target2024.systemDesign.parkingLot.vehicle.Truck;
import target2024.systemDesign.parkingLot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotDemo {
	public static void main(String[] args) {
		ParkingSpot pSpot1 = new ParkingSpot(1, VehicleType.BIKE, null, false);
		ParkingSpot pSpot2 = new ParkingSpot(2, VehicleType.CAR, null, false);
		ParkingSpot pSpot3 = new ParkingSpot(3, VehicleType.CAR, null, false);
		ParkingSpot pSpot4 = new ParkingSpot(4, VehicleType.CAR, null, false);
		ParkingSpot pSpot5 = new ParkingSpot(5, VehicleType.TRUCK, null, false);

		List<ParkingSpot> parkingSpots = new ArrayList<>(Arrays.asList(pSpot1, pSpot2, pSpot3, pSpot4, pSpot5));
		ParkingLot parkingLot = new ParkingLot(parkingSpots, new VehicleBasedFeeStrategy());

		Vehicle bike1 = new Bike("bike1");
		Vehicle bike2 = new Bike("bike2");
		Vehicle car1 = new Car("car1");
		Vehicle car2 = new Car("car2");
		Vehicle truck1 = new Truck("truck1");

		try {
			Ticket t1 = parkingLot.parkVehicle(bike1);
//			Ticket t2 = parkingLot.parkVehicle(bike2);
//			System.out.println(t2.toString());
			Ticket t3 = parkingLot.parkVehicle(car1);
			Ticket t4 = parkingLot.parkVehicle(car2);
			Ticket t5 = parkingLot.parkVehicle(truck1);

			System.out.println("Unparking " + t1.vehicle.regNumber + " with fee=" + parkingLot.unParkVehicle(t1));
			Ticket t6 = parkingLot.parkVehicle(bike2);
			System.out.println("Unparking " + t3.vehicle.regNumber + " with fee=" + parkingLot.unParkVehicle(t3));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
