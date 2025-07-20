package target2024.systemDesign.inventoryMgmt.product;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Product {
	String id;
	String name;
	ProductCategory category;
	
	public Product(String name, ProductCategory category) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.category = category;
	}
}
