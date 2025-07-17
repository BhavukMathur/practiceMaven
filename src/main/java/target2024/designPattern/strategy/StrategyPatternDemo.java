package target2024.designPattern.strategy;

import lombok.AllArgsConstructor;

interface PaymentStrategy {
	void pay();
}

@AllArgsConstructor
class CreditCardPayment implements PaymentStrategy {
	String ccNumber;
	Integer cvv;

	@Override
	public void pay() {
		System.out.println("Paying via Credit Card");
	}
}

@AllArgsConstructor
class UPIPayment implements PaymentStrategy {
	String upiId;

	@Override
	public void pay() {
		System.out.println("Paying via UPI");
	}
}

@AllArgsConstructor
class PaymentStrategyContext {
	PaymentStrategy paymentStrategy;

	public void pay() {
		paymentStrategy.pay();
	}
}

public class StrategyPatternDemo {
	public static void main(String[] args) {
		CreditCardPayment cc = new CreditCardPayment("987", 123);
		UPIPayment upi = new UPIPayment("abc@ybl");

		PaymentStrategyContext context = new PaymentStrategyContext(cc);
		context.pay();
		context = new PaymentStrategyContext(upi);
		context.pay();
	}
}
