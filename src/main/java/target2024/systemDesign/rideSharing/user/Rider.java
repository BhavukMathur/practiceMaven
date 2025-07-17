package target2024.systemDesign.rideSharing.user;

import lombok.Getter;
import target2024.systemDesign.rideSharing.location.Location;

//id, name, phone
@Getter
public class Rider extends User {

	public void setLocation(Location location) {
		this.location = location;
	}

	Location location;

	public Rider(String name, String phone) {
		super(name, phone);
	}
}
