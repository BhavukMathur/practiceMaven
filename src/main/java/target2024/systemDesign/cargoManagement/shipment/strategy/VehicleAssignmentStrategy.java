package target2024.systemDesign.cargoManagement.shipment.strategy;

import target2024.systemDesign.cargoManagement.shipment.Shipment;
import target2024.systemDesign.cargoManagement.shipment.VehicleType;

public interface VehicleAssignmentStrategy {
	public VehicleType assignVehicle(Shipment shipment);
}
