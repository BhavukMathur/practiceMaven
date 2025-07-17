package target2024.systemDesign.selfCheckout.product;

import lombok.Getter;
import target2024.systemDesign.selfCheckout.user.User;

import java.util.List;

@Getter
public class ShoppingCart {
	User user;
	List<ShoppingCartListItem> listItems;
	Double orderValue;

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	Double discount;

	public ShoppingCart(User user, List<ShoppingCartListItem> listItems) {
		this.user = user;
		this.listItems = listItems;
	}

	public void calculateOrdervalue() {
		Double orderValue = 0.0;
		for(ShoppingCartListItem listItem: this.listItems) {
			Double multiplier = listItem.quantity != null ? listItem.quantity : listItem.weight;
			Double listItemOrderValue = listItem.product.price * multiplier;
			orderValue = orderValue + listItemOrderValue;
			listItem.setOrderValue(listItemOrderValue);
		}
		this.orderValue = orderValue;
	}

}
