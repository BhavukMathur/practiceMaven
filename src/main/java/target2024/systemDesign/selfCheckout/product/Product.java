package target2024.systemDesign.selfCheckout.product;

import lombok.Getter;

@Getter
public class Product {
	String id;
	String name;
	Double price;
	ProductCategory category;

	public Product(String name, Double price, ProductCategory category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
}
