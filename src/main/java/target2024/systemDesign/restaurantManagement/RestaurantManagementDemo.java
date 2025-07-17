package target2024.systemDesign.restaurantManagement;

import target2024.systemDesign.restaurantManagement.order.MenuItem;
import target2024.systemDesign.restaurantManagement.order.Order;
import target2024.systemDesign.restaurantManagement.table.Table;

import java.util.HashMap;
import java.util.Map;

public class RestaurantManagementDemo {
	public static void main(String[] args) {
		RestaurantManagementSystem rms = RestaurantManagementSystem.getInstance();

		MenuItem burger = rms.addMenuItem("Burger", 10.0);
		MenuItem fries = rms.addMenuItem("Fries", 5.0);
		MenuItem samosa = rms.addMenuItem("Samosa", 4.0);

		Table table1 = rms.addTable("table1", 2);
		Table table2 = rms.addTable("table2", 2);
		Table table3 = rms.addTable("table3", 2);
		Table table4 = rms.addTable("table4", 6);

		try {
			Table table = rms.reserveTable(3);

			Map menuItemByQuantity = new HashMap<MenuItem, Integer>();
			menuItemByQuantity.put(burger, 2);
			menuItemByQuantity.put(fries, 3);
			menuItemByQuantity.put(samosa, 1);

			Order order1 = rms.placeOrder(menuItemByQuantity, table);
			rms.updateOrderPreparing(order1);
			rms.updateOrderReady(order1);

			//Generate bill
			Double billAmount = rms.generateBill(order1.getId());
			System.out.println("Bill amount for orderId=" + order1.getId() + " =" + billAmount);

			rms.updateOrderPaid(order1);
			rms.unReserveTable(table);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
