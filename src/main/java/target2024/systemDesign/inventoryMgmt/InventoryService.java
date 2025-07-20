package target2024.systemDesign.inventoryMgmt;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import target2024.systemDesign.inventoryMgmt.inventory.InventoryItem;
import target2024.systemDesign.inventoryMgmt.observer.InventoryObserver;
import target2024.systemDesign.inventoryMgmt.product.Product;
import target2024.systemDesign.inventoryMgmt.product.ProductCategory;

//Singleton
public class InventoryService {
	private static InventoryService instance;
	Map<String, InventoryItem> inventory;
	private List<InventoryObserver> observers;
	
	private InventoryService() {
		inventory = new HashMap<>();
		observers = new LinkedList<>();
	}
	
	public static synchronized InventoryService getInstance() {
		if(instance == null) {
			instance = new InventoryService();
		}
		return instance;
	}
	
	public void attachObserver(InventoryObserver observer) {
		observers.add(observer);
	}
	
	
	public void addItem(InventoryItem item) {
		inventory.put(item.getProduct().getId(), item);
	}
	
	public void removeItem(InventoryItem item) {
		inventory.remove(item.getProduct().getId());
	}
	
	public InventoryItem searchItemByName(String productName) {
		return inventory.values().stream()
				.filter(value -> value.getProduct().getName().equals(productName))
				.findFirst()
				.orElse(null);		
	} 
	
	public Product createProduct(String name, ProductCategory category, Integer quantity, Integer reorderThreshold) {
		Product product = new Product(name, category);
		InventoryItem item = new InventoryItem(product, quantity, reorderThreshold);
		inventory.put(product.getId(), item);
		return product;
	}
	
	public void purchase(Product product, Integer quantity) {
		//Update inventory for this product
		InventoryItem item = inventory.get(product.getId());
		item.setQuantity(item.getQuantity() + quantity);
	}
	
	public void sell(Product product, Integer quantity) {
		//Update inventory for this product
		InventoryItem item = inventory.get(product.getId());
		item.setQuantity(item.getQuantity() - quantity);
		notifyObservers(item);
	}
	
	private void notifyObservers(InventoryItem item) {
		observers.forEach(observer -> {
			observer.onQuantityChange(item);
		});
	}
	
	public void printInventory() {
		inventory.values().forEach(value -> {
			System.out.println(value.getProduct().getName() + " : " + value.getQuantity());
		});
	}
	
}
