package target2024.systemDesign.vendingMachine;

import lombok.Getter;
import lombok.Setter;
import target2024.systemDesign.vendingMachine.state.DispenseState;
import target2024.systemDesign.vendingMachine.state.IdleState;
import target2024.systemDesign.vendingMachine.state.InProgressState;
import target2024.systemDesign.vendingMachine.state.ReturnState;
import target2024.systemDesign.vendingMachine.state.VendingMachineState;

//Singleton Design Pattern
//State Design Pattern

@Getter
@Setter
public class VendingMachine {
	private static VendingMachine vendingMachine = null;
	private Inventory inventory;
	private Product selectedProduct;
	private Double totalPayment;
	private VendingMachineState currentState;
	private IdleState idleState;
	private InProgressState inProgressState;
	private DispenseState dispenseState;
	private ReturnState returnState;

	private VendingMachine() {
		inventory = new Inventory();
		selectedProduct = null;
		totalPayment = 0.0;
		idleState = new IdleState(this);
		inProgressState = new InProgressState(this);
		dispenseState = new DispenseState(this);
		returnState = new ReturnState(this);
		currentState = idleState;
	}

	public static synchronized VendingMachine getInstance() {
		if (vendingMachine == null) {
			vendingMachine = new VendingMachine();
		}
		return vendingMachine;
	}

	public void addCoin(Coin coin) {
		totalPayment = totalPayment + coin.getValue();
	}

	public void reset() {
		this.currentState = idleState;
		this.totalPayment = 0.0;
		this.selectedProduct = null;
	}

	public Product addProduct(String productName, Double price, Integer quantity) {
		Product product = new Product(productName, price);
		this.inventory.addProduct(product, quantity);
		return product;
	}

	public void selectProduct(Product product) {
		this.currentState.selectProduct(product);
	}

	public void insertCoin(Coin coin) {
		this.currentState.insertCoin(coin);
	}

	public void dispenseProduct() {
		this.currentState.dispenseProduct();
	}

	public void returnChange() {
		this.currentState.returnChange();
	}

}
