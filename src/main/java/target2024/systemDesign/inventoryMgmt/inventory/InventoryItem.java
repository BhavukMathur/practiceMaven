package target2024.systemDesign.inventoryMgmt.inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import target2024.systemDesign.inventoryMgmt.product.Product;

@Getter
@AllArgsConstructor
public class InventoryItem {
	Product product;
	@Setter
	Integer quantity;
	Integer reorderThreshold;
}
