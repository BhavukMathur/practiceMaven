package target2024.systemDesign.cargoManagement.shipment;

import lombok.Getter;

@Getter
public enum VehicleType {
	
	VAN(20, 100),
	TRUCK(100, 100),
	SHIP(500, 10000),
	PLANE(50, 10000);
	
	int maxWeight, maxDistance;
	
	VehicleType(int maxWeight, int maxDistance) {
		this.maxDistance = maxDistance;
		this.maxWeight = maxWeight;
	}
}
