package target2024.systemDesign.restaurantManagement.order;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class OrderItem {
	MenuItem menuItem;
	Integer quantity;

	public static List<OrderItem> mapMenuItemsToOrderItems(Map<MenuItem, Integer> menuItemsByQuantity) {
		List<OrderItem> orderItems = new LinkedList<>();
		for(Map.Entry<MenuItem, Integer> entry: menuItemsByQuantity.entrySet()) {
			OrderItem orderItem = new OrderItem(entry.getKey(), entry.getValue());
			orderItems.add(orderItem);
		}
		return orderItems;
	}
}
