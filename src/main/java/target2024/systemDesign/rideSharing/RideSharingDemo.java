package target2024.systemDesign.rideSharing;

import target2024.systemDesign.rideSharing.location.DriverAssignmentStrategy;
import target2024.systemDesign.rideSharing.location.Location;
import target2024.systemDesign.rideSharing.location.LocationBasedDriverAssignment;
import target2024.systemDesign.rideSharing.trip.Trip;
import target2024.systemDesign.rideSharing.user.Driver;
import target2024.systemDesign.rideSharing.user.Rider;

public class RideSharingDemo {
	public static void main(String[] args) {
		Rider rider1 = new Rider("rider1", "98765");
		Rider rider2 = new Rider("rider2", "99999");

		DriverAssignmentStrategy strategy = new LocationBasedDriverAssignment();

		RideSharingService service = RideSharingService.getInstance();
		service.setStrategy(strategy);

		Driver driver1 = service.registerDriver("driver1", "10000", "KA-01", "Indica", new Location(1.0, 3.0));
		Driver driver2 = service.registerDriver("driver2", "20000", "KA-02", "Xcent", new Location(10.0, 30.0));

		rider1.setLocation(new Location(11.0, 31.0));

		Trip trip1 = service.createTrip(rider1);
		System.out.println("Trip created between rider=" + rider1.getName() + " and Driver=" + trip1.getDriver().getName());
	}
}
