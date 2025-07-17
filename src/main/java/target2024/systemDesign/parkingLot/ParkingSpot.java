package target2024.systemDesign.parkingLot;

import lombok.AllArgsConstructor;
import lombok.Data;
import target2024.systemDesign.parkingLot.vehicle.Vehicle;

@AllArgsConstructor
@Data
public class ParkingSpot {
	int id;
	VehicleType vehicleType;
	Vehicle vehicle;
	boolean isOccupied;
}
