package target2024.systemDesign.parkingLot;

import lombok.AllArgsConstructor;
import target2024.systemDesign.parkingLot.fees.FeeStrategy;
import target2024.systemDesign.parkingLot.vehicle.Vehicle;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class ParkingLot {
	List<ParkingSpot> parkingSpots;
	FeeStrategy feeStrategy;

	public Ticket parkVehicle(Vehicle vehicle) throws Exception {
		ParkingSpot parkingSpot = findParkingIfExists(vehicle);
		Ticket ticket = new Ticket(
				new Date().getTime(), null, vehicle, UUID.randomUUID().toString(), parkingSpot
		);
		System.out.println(ticket);
		return ticket;
	}

	public int unParkVehicle(Ticket ticket) throws Exception {
		ParkingSpot parkingSpot = ticket.parkingSpot;
		parkingSpot.isOccupied = false;
		parkingSpot.vehicle = null;

		//Return fees
		int fee = feeStrategy.calculateFees(ticket);
		return fee;
	}

	private ParkingSpot findParkingIfExists(Vehicle vehicle) throws Exception {
		for(ParkingSpot parkingSpot: parkingSpots) {
			if(parkingSpot.isOccupied == false && (parkingSpot.vehicleType == vehicle.vehicleType)) {
				parkingSpot.isOccupied = true;
				parkingSpot.vehicle = vehicle;
				return parkingSpot;
			}
		}
		throw new Exception("No parking found for vehicle=" + vehicle.regNumber);
	}
}
