package target2024.systemDesign.foodDelivery.restaurant;

import lombok.Getter;

import java.util.List;

@Getter
public class Restaurant {
	String id;
	String name;
	String address;
	String addressGeoHash; //GeoHash
	List<MenuItem> menu;

	public Restaurant(String name, String address, List<MenuItem> menu) {
		this.name = name;
		this.address = address;
		this.menu = menu;
	}
}
