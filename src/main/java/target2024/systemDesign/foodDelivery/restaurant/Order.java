package target2024.systemDesign.foodDelivery.restaurant;

import lombok.Getter;
import target2024.systemDesign.foodDelivery.deliveryAgent.DeliveryAgent;
import target2024.systemDesign.foodDelivery.user.User;

import java.util.List;
import java.util.UUID;

@Getter
public class Order {
	String id;
	User user;

	public void setAgent(DeliveryAgent agent) {
		this.agent = agent;
	}

	DeliveryAgent agent;
	Restaurant restaurant;
	List<OrderLineItem> orderItems;
	OrderStatus status;

	public Order(User user, Restaurant restaurant, List<OrderLineItem> orderItems) {
		this.id = UUID.randomUUID().toString();
		this.user = user;
		this.restaurant = restaurant;
		this.status = OrderStatus.PENDING;
		this.orderItems = orderItems;
	}

	public void confirm() {
		this.status = OrderStatus.CONFIRMED;
	}

	public void deliver() {
		this.status = OrderStatus.DELIVERED;
		this.agent.setAvailable(true);
	}
}
