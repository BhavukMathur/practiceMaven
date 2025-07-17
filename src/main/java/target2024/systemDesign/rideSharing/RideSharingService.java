package target2024.systemDesign.rideSharing;

import target2024.systemDesign.rideSharing.location.DriverAssignmentStrategy;
import target2024.systemDesign.rideSharing.location.Location;
import target2024.systemDesign.rideSharing.trip.Trip;
import target2024.systemDesign.rideSharing.trip.TripStatus;
import target2024.systemDesign.rideSharing.user.Driver;
import target2024.systemDesign.rideSharing.user.Rider;

import java.util.LinkedList;
import java.util.List;

//Singleton design pattern
public class RideSharingService {
	private static RideSharingService instance;
	List<Driver> drivers;

	public void setStrategy(DriverAssignmentStrategy strategy) {
		this.strategy = strategy;
	}

	DriverAssignmentStrategy strategy;

	private RideSharingService() {
		drivers = new LinkedList<>();
	}

	public static synchronized RideSharingService getInstance() {
		if(instance == null) {
			instance = new RideSharingService();
		}
		return instance;
	}

	public Driver registerDriver(String name, String phone, String licence, String vehicle, Location location) {
		Driver driver = new Driver(name, phone, licence, vehicle, location);
		drivers.add(driver);
		return driver;
	}

	public Trip createTrip(Rider rider) {
		//1. Match the driver
		Driver driver = strategy.getDriver(rider, drivers);

		//2. Set the price -- pricing strategy
		Trip trip = new Trip(driver, rider, rider.getLocation(), driver.getLocation(), 100.0);

		//3. Driver to accept the trip
		driver.accept(trip);
		trip.setStatus(TripStatus.IN_PROGRESS);
		return trip;
	}
}
