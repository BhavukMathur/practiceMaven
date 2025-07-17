package target2024.systemDesign.vendingMachine;

import lombok.Getter;

@Getter
public enum Coin {
	QUARTER(0.25),
	HALF(0.50),
	ONE(1.0),
	FIVE(5.0);

	Double value;

	Coin(Double value) {
		this.value = value;
	}
}
