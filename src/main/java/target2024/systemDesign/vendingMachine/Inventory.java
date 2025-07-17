package target2024.systemDesign.vendingMachine;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
	private Map<Product, Integer> productQuantities;

	Inventory() {
		productQuantities = new HashMap<>();
	}

	public void addProduct(Product product, Integer quantity) {
		if(productQuantities.get(product) != null) {
			productQuantities.put(product, quantity);
		} else {
			updateQuantity(product, quantity);
		}
	}

	public void removeProduct(Product product) {
		productQuantities.remove(product);
	}

	public void updateQuantity(Product product, Integer quantity) {
		productQuantities.put(product, quantity);
	}

	public Integer getQuantity(Product product) {
		return productQuantities.get(product);
	}

	public boolean isAvailable(Product product) {
		return productQuantities.get(product) > 0;
	}
}
