package target2024.java8;

@java.lang.FunctionalInterface
//Only one abstract method
interface Calculator {
	int calculate(int a, int b);

	default void func() {
		System.out.println("Default method");
	}
}

class CalculatorImpl1 implements Calculator {

	@Override
	public int calculate(int a, int b) {
		return 0;
	}
}

class CalculatorImpl2 implements Calculator {

	@Override
	public int calculate(int a, int b) {
		return 0;
	}

	public void func() {
		System.out.println("Default method");
	}
}

public class FunctionalInterface {
	public static void main(String[] args) {
		Calculator adder = (a, b) -> a + b;
		Calculator subtractor = (a, b) -> a - b;

		System.out.println(adder.calculate(2, 3));
		System.out.println(subtractor.calculate(2, 3));
	}
}
