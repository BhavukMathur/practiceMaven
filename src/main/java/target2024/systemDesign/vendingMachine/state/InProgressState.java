package target2024.systemDesign.vendingMachine.state;

import lombok.AllArgsConstructor;
import target2024.systemDesign.vendingMachine.Coin;
import target2024.systemDesign.vendingMachine.Product;
import target2024.systemDesign.vendingMachine.VendingMachine;

@AllArgsConstructor
public class InProgressState implements VendingMachineState {

	private final VendingMachine vendingMachine;

	@Override
	public void selectProduct(Product product) {
		System.out.println("Not supported");
	}

	@Override
	public void insertCoin(Coin coin) {
		vendingMachine.addCoin(coin);
		System.out.println("Coin inserted=" + coin.getValue());
		checkPaymentStatus();
	}

	@Override
	public void dispenseProduct() {
		System.out.println("Not supported");
	}

	@Override
	public void returnChange() {
		System.out.println("Not supported");
	}

	private void checkPaymentStatus() {
		if(vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()) {
			vendingMachine.setCurrentState(vendingMachine.getDispenseState());
		}
	}
}
