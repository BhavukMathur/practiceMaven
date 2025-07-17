package target2024.java8;

public class LambdaVsAnonymousInnerClass {
	public static void main(String[] args) {
		//Anonymous inner class
		int var = 100;
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				int var = 200;
				System.out.println("Inside aic: " + var);
			}
		});

		//Lambda
		//Less verbose, does not have its separate scope. Shares with outer.
		//Uses final variables
		Thread thread2 = new Thread(() -> {
//			int var = 200;
			System.out.println("Inside lambda: " + var);
		});

		thread1.start();
		thread2.start();
	}
}
