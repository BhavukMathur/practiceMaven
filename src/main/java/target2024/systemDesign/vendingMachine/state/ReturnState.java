package target2024.systemDesign.vendingMachine.state;

import lombok.AllArgsConstructor;
import target2024.systemDesign.vendingMachine.Coin;
import target2024.systemDesign.vendingMachine.Product;
import target2024.systemDesign.vendingMachine.VendingMachine;

@AllArgsConstructor
public class ReturnState implements VendingMachineState {

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
		System.out.println("Not supported");
	}

	@Override
	public void returnChange() {
		double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice();
		if(change > 0) {
			System.out.println("Change returned=" + change);
		} else {
			System.out.println("No change to return");
		}
		vendingMachine.reset();
	}
}
