package target2024.systemDesign.parkingLot.vehicle;

import target2024.systemDesign.parkingLot.VehicleType;

public abstract class Vehicle {
	public String regNumber;
	public VehicleType vehicleType;

	public Vehicle(String regNumber, VehicleType vehicleType) {
		this.regNumber = regNumber;
		this.vehicleType = vehicleType;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}
}
