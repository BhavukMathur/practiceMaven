package target2024.systemDesign.foodDelivery.deliveryAgent;

import target2024.systemDesign.foodDelivery.restaurant.Order;

import java.util.List;

public interface DeliveryAgentStrategy {
	public DeliveryAgent assignDeliveryAgent(Order order, List<DeliveryAgent> deliveryAgents);
}
