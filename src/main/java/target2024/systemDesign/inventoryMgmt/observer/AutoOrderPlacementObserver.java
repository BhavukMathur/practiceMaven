package target2024.systemDesign.inventoryMgmt.observer;

import target2024.systemDesign.inventoryMgmt.InventoryService;
import target2024.systemDesign.inventoryMgmt.inventory.InventoryItem;

public class AutoOrderPlacementObserver extends InventoryObserver {

	@Override
	public void onQuantityChange(InventoryItem item) {
		if(item.getQuantity() < item.getReorderThreshold()) {
			int diff = item.getReorderThreshold() - item.getQuantity();
			System.out.println("To purchase for : " + item.getProduct().getName() + " : " + diff);
		}
	}
	
	public AutoOrderPlacementObserver(InventoryService service) {
		this.service = service;
	}
}
