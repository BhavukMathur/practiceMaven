package target2024.systemDesign.vendingMachine.state;

import lombok.AllArgsConstructor;
import target2024.systemDesign.vendingMachine.Coin;
import target2024.systemDesign.vendingMachine.Product;
import target2024.systemDesign.vendingMachine.VendingMachine;

@AllArgsConstructor
public class IdleState implements VendingMachineState {

	private final VendingMachine vendingMachine;

	@Override
	public void selectProduct(Product product) {
		if(vendingMachine.getInventory().isAvailable(product)) {
			System.out.println("Product selected=" + product.getName());
			vendingMachine.setSelectedProduct(product);
			vendingMachine.setCurrentState(vendingMachine.getInProgressState());
		} else {
			System.out.println("Product not found");
		}
	}

	@Override
	public void insertCoin(Coin coin) {
		System.out.println("Not supported");
	}

	@Override
	public void dispenseProduct() {
		System.out.println("Not supported");
	}

	@Override
	public void returnChange() {
		System.out.println("Not supported");
	}
}
