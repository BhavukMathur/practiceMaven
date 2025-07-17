package target2024.systemDesign.restaurantManagement;

import target2024.systemDesign.restaurantManagement.order.MenuItem;
import target2024.systemDesign.restaurantManagement.order.Order;
import target2024.systemDesign.restaurantManagement.order.OrderItem;
import target2024.systemDesign.restaurantManagement.table.Table;
import target2024.systemDesign.restaurantManagement.table.TableStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Singleton Design Pattern
public class RestaurantManagementSystem {
	private static RestaurantManagementSystem instance;

	private Map<String, MenuItem> menu;
	private List<Table> tables;
	private Map<String, Order> orderById;

	private RestaurantManagementSystem() {
		menu = new HashMap<>();
		tables = new LinkedList<>();
		orderById = new HashMap<>();
	}

	public static synchronized RestaurantManagementSystem getInstance() {
		if(instance == null) {
			instance = new RestaurantManagementSystem();
		}
		return instance;
	}

	public MenuItem addMenuItem(String itemName, Double price) {
		MenuItem menuItem = new MenuItem(itemName, price);
		menu.put(itemName, menuItem);
		return menuItem;
	}

	public Table addTable(String id, int capacity) {
		Table table = new Table(id, capacity);
		tables.add(table);
		return table;
	}

	public Order placeOrder(Map<MenuItem, Integer> menuItemsByQuantity, Table table) throws Exception {
		List<OrderItem> orderItems = OrderItem.mapMenuItemsToOrderItems(menuItemsByQuantity);
		Order order = new Order(orderItems, table);
		orderById.put(order.getId(), order);
		return order;
	}

	public Table reserveTable(int reqCapacity) throws Exception {
		for(Table table: tables) {
			if((table.getTableStatus() == TableStatus.AVAILABLE) && (table.getCapacity() >= reqCapacity)) {
				table.reserve();
				return table;
			}
		}
		throw new Exception("No Table Found");
	}

	public void unReserveTable(Table table) {
		table.unReserve();
	}
	public void updateOrderPreparing(Order order) {
		order.updateOrderPreparing();
	}
	public void updateOrderReady(Order order) {
		order.updateOrderReady();
	}
	public void updateOrderPaid(Order order) {
		order.updateOrderPaid();
	}

	public Double generateBill(String orderId) {
		Order order = orderById.get(orderId);
		return order.generateBill();
	}

}
