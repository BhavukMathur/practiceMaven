package target2024.systemDesign.foodDelivery;

import target2024.systemDesign.foodDelivery.deliveryAgent.DeliveryAgentStrategy;
import target2024.systemDesign.foodDelivery.restaurant.MenuItem;
import target2024.systemDesign.foodDelivery.restaurant.Order;
import target2024.systemDesign.foodDelivery.restaurant.OrderLineItem;
import target2024.systemDesign.foodDelivery.restaurant.Restaurant;
import target2024.systemDesign.foodDelivery.deliveryAgent.DeliveryAgent;
import target2024.systemDesign.foodDelivery.user.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Singleton Design pattern
public class FoodDeliveryService {
	private static FoodDeliveryService instance;
	private List<DeliveryAgent> deliveryAgents;
	private List<Restaurant> restaurants;

	//Strategy Design Pattern
	private DeliveryAgentStrategy deliveryAgentStrategy;
	
	public void setDeliveryAgentStrategy(DeliveryAgentStrategy deliveryAgentStrategy) {
		this.deliveryAgentStrategy = deliveryAgentStrategy;
	}


	private FoodDeliveryService() {
		deliveryAgents = new ArrayList<>();
		restaurants = new ArrayList<>();
	}

	public synchronized static FoodDeliveryService getInstance() {
		if(instance == null) {
			instance = new FoodDeliveryService();
		}
		return instance;
	}

	public DeliveryAgent registerDeliveryAgent(String name, String phoneNumber) {
		DeliveryAgent da = new DeliveryAgent(name, phoneNumber);
		deliveryAgents.add(da);
		return da;
	}

	public Restaurant registerRestaurant(String name, String address, List<MenuItem> menu) {
		Restaurant restaurant = new Restaurant(name, address, menu);
		restaurants.add(restaurant);
		return restaurant;
	}

	public Order createOrder(Restaurant restaurant, User user, Map<MenuItem, Integer> menuByQuantity) {
		List<OrderLineItem> orderLineItems = new LinkedList<>();

		for(Map.Entry<MenuItem, Integer> entry: menuByQuantity.entrySet()) {
			OrderLineItem lineItem = new OrderLineItem(entry.getKey(), entry.getValue());
			orderLineItems.add(lineItem);
		}

		Order order = new Order(user, restaurant, orderLineItems);
		System.out.println("Order created successfully. Id=" + order.getId());
		return order;
	}

	public void payAndConfirmOrder(Order order) {
		System.out.println("Order confirmed. Id=" + order.getId());
		order.confirm();

		//Assigning delivery agent
		DeliveryAgent agent = assignDeliveryAgent(order);
		order.setAgent(agent);
		System.out.println("Delivery partner assigned. PartnerId=" + agent.getName());
	}

	public void deliverOrder(Order order) {
		order.deliver();
	}

	private synchronized DeliveryAgent assignDeliveryAgent(Order order) {
		DeliveryAgent da = deliveryAgentStrategy.assignDeliveryAgent(order, deliveryAgents);
		return da;
	}
}
