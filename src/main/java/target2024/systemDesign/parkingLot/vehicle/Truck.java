package target2024.systemDesign.parkingLot.vehicle;

import lombok.Getter;
import target2024.systemDesign.parkingLot.VehicleType;

@Getter
public class Truck extends Vehicle {
	public Truck(String regNumber) {
		super(regNumber, VehicleType.TRUCK);
	}
}
