package target2024.systemDesign.inventoryMgmt.observer;

import target2024.systemDesign.inventoryMgmt.InventoryService;
import target2024.systemDesign.inventoryMgmt.inventory.InventoryItem;

public abstract class InventoryObserver {
	InventoryService service;
	public abstract void onQuantityChange(InventoryItem item);
}
