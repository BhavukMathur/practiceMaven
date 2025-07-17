package target2024.systemDesign.restaurantManagement.order;

import lombok.Getter;
import target2024.systemDesign.restaurantManagement.table.Table;

import java.util.List;
import java.util.UUID;

@Getter
public class Order {
	String id;
	List<OrderItem> orderItems;
	OrderStatus orderStatus;
	Table table;
	Double orderValue;

	public Order(List<OrderItem> orderItems, Table table) {
		this.id = UUID.randomUUID().toString();
		this.orderItems = orderItems;
		this.orderStatus = OrderStatus.IN_PROGRESS;
		this.table = table;
	}

	public void updateOrderPreparing() {
		this.orderStatus = OrderStatus.PREPARING;
	}
	public void updateOrderReady() {
		this.orderStatus = OrderStatus.READY;
	}
	public void updateOrderPaid() {
		this.orderStatus = OrderStatus.PAID;
	}

	public Double generateBill() {
		this.orderValue = 0.0;
		for(OrderItem orderItem: this.getOrderItems()) {
			this.orderValue = this.orderValue + (orderItem.menuItem.getPrice() * orderItem.quantity);
		}
		return this.orderValue;
	}
}
