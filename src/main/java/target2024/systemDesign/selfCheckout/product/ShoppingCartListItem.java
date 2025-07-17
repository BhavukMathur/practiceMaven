package target2024.systemDesign.selfCheckout.product;

import lombok.Getter;

@Getter
public class ShoppingCartListItem {
	Product product;
	Double weight;
	Double quantity;
	Double orderValue;
	Double discount;

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}


	public ShoppingCartListItem(Product product, Double weight, Double quantity) {
		this.product = product;
		this.weight = weight;
		this.quantity = quantity;
		this.discount = 0.0;
	}
}
