package target2024.systemDesign.vendingMachine;

public class VendingMachineDemo {
	public static void main(String[] args) {
		VendingMachine vendingMachine = VendingMachine.getInstance();

		Product pepsi = vendingMachine.addProduct("Pepsi", 2.5, 3);
		Product coke = vendingMachine.addProduct("Coke", 2.5, 1);
		Product kitKat = vendingMachine.addProduct("Kit-Kat", 5.0, 2);
		Product juice = vendingMachine.addProduct("Juice", 1.0, 2);

		vendingMachine.selectProduct(coke);

		vendingMachine.insertCoin(Coin.ONE);
		vendingMachine.insertCoin(Coin.ONE);
		vendingMachine.insertCoin(Coin.ONE);

		vendingMachine.dispenseProduct();

		vendingMachine.returnChange();
	}
}
