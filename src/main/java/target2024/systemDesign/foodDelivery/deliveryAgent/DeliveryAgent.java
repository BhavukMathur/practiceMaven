package target2024.systemDesign.foodDelivery.deliveryAgent;

import lombok.Getter;
import target2024.systemDesign.foodDelivery.restaurant.Order;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Getter
public class DeliveryAgent {
	String id;
	String name;
	String phoneNumber;

	public void setAvailable(boolean available) {
		isAvailable = available;
	}

	boolean isAvailable;
	//List<Order> orders;
	String curLocation; //GeoHash

	public DeliveryAgent(String name, String phoneNumber) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.isAvailable = true;
//		orders = new LinkedList<>();
	}
}
