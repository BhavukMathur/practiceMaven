package target2024.systemDesign.vendingMachine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
	private String name;
	private Double price;
}
