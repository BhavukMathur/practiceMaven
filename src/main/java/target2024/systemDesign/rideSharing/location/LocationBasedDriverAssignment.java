package target2024.systemDesign.rideSharing.location;

import target2024.systemDesign.rideSharing.user.Driver;
import target2024.systemDesign.rideSharing.user.DriverStatus;
import target2024.systemDesign.rideSharing.user.Rider;
import target2024.systemDesign.rideSharing.user.User;

import java.util.List;

public class LocationBasedDriverAssignment implements DriverAssignmentStrategy {
	@Override
	public Driver getDriver(Rider rider, List<Driver> drivers) {
		double distance = Double.MAX_VALUE;
		Driver assignedDriver = null;
		for(Driver driver: drivers) {
			if(driver.getStatus() == DriverStatus.AVAILABLE) {
				if(driver.getLocation().distanceTo(rider.getLocation()) < distance) {
					assignedDriver = driver;
				}
			}
		}
		if(assignedDriver != null) {
			return assignedDriver;
		}
		throw new RuntimeException("No driver available");
	}
}
