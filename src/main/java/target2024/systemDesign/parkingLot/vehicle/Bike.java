package target2024.systemDesign.parkingLot.vehicle;

import lombok.Getter;
import target2024.systemDesign.parkingLot.VehicleType;

@Getter
public class Bike extends Vehicle {
	public Bike(String regNumber) {
		super(regNumber, VehicleType.BIKE);
	}
}
