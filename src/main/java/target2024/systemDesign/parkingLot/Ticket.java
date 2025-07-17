package target2024.systemDesign.parkingLot;

import lombok.AllArgsConstructor;
import lombok.Data;
import target2024.systemDesign.parkingLot.vehicle.Vehicle;

@Data
@AllArgsConstructor
public class Ticket {
	Long entryTime;
	Long exitTime;
	Vehicle vehicle;
	String ticketId;
	ParkingSpot parkingSpot;

	public String toString() {
		return ("vehicle=" + vehicle.regNumber + " ticketId=" + ticketId + " parkingSpot=" + parkingSpot.id);
	}
}
