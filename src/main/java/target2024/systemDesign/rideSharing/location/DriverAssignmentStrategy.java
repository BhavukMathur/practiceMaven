package target2024.systemDesign.rideSharing.location;

import target2024.systemDesign.rideSharing.user.Driver;
import target2024.systemDesign.rideSharing.user.Rider;
import target2024.systemDesign.rideSharing.user.User;

import java.util.List;

public interface DriverAssignmentStrategy {
	public Driver getDriver(Rider rider, List<Driver> drivers);
}
