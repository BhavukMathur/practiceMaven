package target2024.systemDesign.foodDelivery;

import target2024.systemDesign.foodDelivery.deliveryAgent.DeliveryAgentStrategy;
import target2024.systemDesign.foodDelivery.deliveryAgent.SimpleDeliveryAgentStrategy;
import target2024.systemDesign.foodDelivery.restaurant.MenuItem;
import target2024.systemDesign.foodDelivery.restaurant.Order;
import target2024.systemDesign.foodDelivery.restaurant.Restaurant;
import target2024.systemDesign.foodDelivery.deliveryAgent.DeliveryAgent;
import target2024.systemDesign.foodDelivery.user.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FoodDeliveryDemo {
	public static void main(String[] args) {
		FoodDeliveryService service = FoodDeliveryService.getInstance();
		DeliveryAgentStrategy strategy = new SimpleDeliveryAgentStrategy();
		service.setDeliveryAgentStrategy(strategy);

		User user1 = new User("Sachin", "9999");
		User user2 = new User("Ponting", "9999");
		DeliveryAgent da1 = service.registerDeliveryAgent("DA1", "8888");
		DeliveryAgent da2 = service.registerDeliveryAgent("DA2", "8888");
		DeliveryAgent da3 = service.registerDeliveryAgent("DA3", "8888");

		MenuItem burger = new MenuItem("burger", 10.0);
		MenuItem fries = new MenuItem("fries", 10.0);
		MenuItem samosa = new MenuItem("samosa", 10.0);

		List<MenuItem> menu = new LinkedList<>(Arrays.asList(burger, fries, samosa));
		Restaurant restaurant1 =  service.registerRestaurant("Rest-1", "someAddress", menu);

		//Place order

		try {
			Map<MenuItem, Integer> menuByQuantity = new HashMap<>();
			menuByQuantity.put(burger, 3);
			menuByQuantity.put(samosa, 2);

			Order order1 = service.createOrder(restaurant1, user1, menuByQuantity);
			//Make payment
			service.payAndConfirmOrder(order1);

			Order order2 = service.createOrder(restaurant1, user2, menuByQuantity);
			//Make payment
			service.payAndConfirmOrder(order2);

			service.deliverOrder(order2);
			service.deliverOrder(order1);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
