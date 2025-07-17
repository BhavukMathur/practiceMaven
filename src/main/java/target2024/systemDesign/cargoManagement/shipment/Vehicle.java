package target2024.systemDesign.cargoManagement.shipment;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Vehicle {
	String id;
	String regNumber;
	VehicleType vehicleType;
	
	public Vehicle(String regNumber, VehicleType vehicleType) {
		this.id = UUID.randomUUID().toString();
		this.regNumber = regNumber;
		this.vehicleType = vehicleType;
	}
}
