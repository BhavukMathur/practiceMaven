package target2024.systemDesign.rideSharing.user;

import lombok.Getter;
import target2024.systemDesign.rideSharing.location.Location;
import target2024.systemDesign.rideSharing.trip.Trip;

//id, name, phone
@Getter
public class Driver extends User{
	DriverStatus status;
	String licence;
	String vehicle;
	Location location;
	Trip currentTrip;

	public Driver(String name, String phone, String licence, String vehicle, Location location) {
		super(name, phone);
		this.licence = licence;
		this.vehicle = vehicle;
		this.location = location;
		this.status = DriverStatus.AVAILABLE;
	}

	public synchronized void accept(Trip trip) {
		this.currentTrip = trip;
		this.status = DriverStatus.OCCUPIED;
	}
}
