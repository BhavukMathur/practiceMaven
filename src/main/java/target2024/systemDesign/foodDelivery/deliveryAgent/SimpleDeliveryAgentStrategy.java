package target2024.systemDesign.foodDelivery.deliveryAgent;

import target2024.systemDesign.foodDelivery.restaurant.Order;

import java.util.List;

public class SimpleDeliveryAgentStrategy implements DeliveryAgentStrategy {
	@Override
	public DeliveryAgent assignDeliveryAgent(Order order, List<DeliveryAgent> deliveryAgents) {
		for(DeliveryAgent da: deliveryAgents) {
			if(da.isAvailable) {
				da.setAvailable(false);
				return da;
			}
		}
		throw new RuntimeException("No delivery partner available");
	}
}
