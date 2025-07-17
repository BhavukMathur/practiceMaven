package target2024.systemDesign.rideSharing.location;

public class Location {
	String geoHash;
	Double longitude;
	Double latitude;

	public Location(Double longitude, Double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Double distanceTo(Location location) {
		double dx = location.longitude - this.longitude;
		double dy = location.latitude - this.latitude;

		return Math.sqrt(dx*dx + dy*dy); 	//Euclidian
	}
}
