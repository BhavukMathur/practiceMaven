package target2024.systemDesign.vendingMachine.state;

import lombok.AllArgsConstructor;
import target2024.systemDesign.vendingMachine.Coin;
import target2024.systemDesign.vendingMachine.Product;
import target2024.systemDesign.vendingMachine.VendingMachine;

@AllArgsConstructor
public class DispenseState implements VendingMachineState {

	private final VendingMachine vendingMachine;

	@Override
	public void selectProduct(Product product) {
		System.out.println("Not supported");
	}

	@Override
	public void insertCoin(Coin coin) {
		System.out.println("Not supported");
	}

	@Override
	public void dispenseProduct() {
		Product product = vendingMachine.getSelectedProduct();
		vendingMachine.getInventory().updateQuantity(product, vendingMachine.getInventory().getQuantity(product) - 1);
		System.out.println("Product dispensed=" + product.getName());
		vendingMachine.setCurrentState(vendingMachine.getReturnState());
	}

	@Override
	public void returnChange() {
		System.out.println("Not supported");
	}
}
