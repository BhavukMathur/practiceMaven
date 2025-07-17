package target2024.systemDesign.rideSharing.trip;

import lombok.Getter;
import target2024.systemDesign.rideSharing.location.Location;
import target2024.systemDesign.rideSharing.user.Driver;
import target2024.systemDesign.rideSharing.user.Rider;

@Getter
public class Trip {
	Driver driver;
	Rider rider;
	Location origin;
	Location destination;
	Double price;

	public void setStatus(TripStatus status) {
		this.status = status;
	}

	TripStatus status;

	public Trip(Driver driver, Rider rider, Location origin, Location destination, Double price) {
		this.driver = driver;
		this.rider = rider;
		this.origin = origin;
		this.destination = destination;
		this.price = price;
		this.status = TripStatus.REQUESTED;
	}
}
