package target2024.systemDesign.cargoManagement.shipment.strategy;

import target2024.systemDesign.cargoManagement.cargo.Cargo;
import target2024.systemDesign.cargoManagement.shipment.Shipment;
import target2024.systemDesign.cargoManagement.shipment.VehicleType;

public class WeightBasedAssignmentStrategy implements VehicleAssignmentStrategy {

	@Override
	public VehicleType assignVehicle(Shipment shipment) {
		Double totalWeight = 0.0;
		
		for(Cargo cargo: shipment.getCargos()) {
			totalWeight = totalWeight + cargo.getWeight();
		}
		
		for(VehicleType vehicleType: VehicleType.values()) {
			if(vehicleType.getMaxWeight() >= totalWeight) {
				return vehicleType;
			}
		}
		
		return VehicleType.TRUCK;
	}
	
}
