package target2024.systemDesign.vendingMachine.state;

import target2024.systemDesign.vendingMachine.Coin;
import target2024.systemDesign.vendingMachine.Product;

public interface VendingMachineState {
	void selectProduct(Product product);
	void insertCoin(Coin coin);
	void dispenseProduct();
	void returnChange();
}
