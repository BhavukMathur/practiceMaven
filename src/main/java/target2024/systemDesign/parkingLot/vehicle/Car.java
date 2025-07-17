package target2024.systemDesign.parkingLot.vehicle;

import lombok.Getter;
import target2024.systemDesign.parkingLot.VehicleType;

@Getter
public class Car extends Vehicle {
	public Car(String regNumber) {
		super(regNumber, VehicleType.CAR);
	}
}
