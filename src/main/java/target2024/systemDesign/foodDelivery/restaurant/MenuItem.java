package target2024.systemDesign.foodDelivery.restaurant;

import lombok.Getter;

import java.util.UUID;

@Getter
public class MenuItem {
	String id;
	String name;
	Double price;
	boolean isAvailable;

	public MenuItem(String name, Double price) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.price = price;
		this.isAvailable = true;
	}
}
