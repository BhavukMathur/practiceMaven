package target2024.systemDesign.parkingLot.fees;

import target2024.systemDesign.parkingLot.Ticket;
import target2024.systemDesign.parkingLot.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy {

	static Map<VehicleType, Integer> vehicleTypeIntegerMap;

	static {
		vehicleTypeIntegerMap = new HashMap<>();
		vehicleTypeIntegerMap.put(VehicleType.BIKE, 10);
		vehicleTypeIntegerMap.put(VehicleType.CAR, 20);
		vehicleTypeIntegerMap.put(VehicleType.TRUCK, 30);
	}

	@Override
	public int calculateFees(Ticket ticket) {
		return vehicleTypeIntegerMap.get(ticket.getVehicle().getVehicleType());
	}
}
