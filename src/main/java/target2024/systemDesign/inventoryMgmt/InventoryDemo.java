package target2024.systemDesign.inventoryMgmt;

import target2024.systemDesign.inventoryMgmt.inventory.InventoryItem;
import target2024.systemDesign.inventoryMgmt.observer.AutoOrderPlacementObserver;
import target2024.systemDesign.inventoryMgmt.observer.InventoryObserver;
import target2024.systemDesign.inventoryMgmt.product.Product;
import target2024.systemDesign.inventoryMgmt.product.ProductCategory;

public class InventoryDemo {
	public static void main(String[] args) {
		InventoryService service = InventoryService.getInstance();
		
		Product product1 = service.createProduct("MacBook", ProductCategory.ELECTRONICS, 10, 5);
		Product product2 = service.createProduct("iPhone", ProductCategory.ELECTRONICS, 20, 5);
		Product product3 = service.createProduct("ToyCar", ProductCategory.TOYS, 40, 5);
		
		InventoryObserver autoOrderPlacementObserver = new AutoOrderPlacementObserver(service);
		service.attachObserver(autoOrderPlacementObserver);
		
//		InventoryItem item = service.searchItemByName("iPhone");
//		System.out.println(item.getProduct().getName() + " " + item.getQuantity());
		
		
		service.printInventory();
		service.purchase(product2, 5);
		service.printInventory();		
		service.sell(product2, 23);
		service.printInventory();
	}
}
