package target2024.divideAndConquer;

public class Power {
	public static void main(String[] args) {
		Power power = new Power();
		double x = 2.00000;
		int n = 10;
		System.out.println(power.myPow(x, n));
	}

	public double myPow(double x, int n) {
		if(x == 0) {
			return 0;
		}
		if(x == 1) {
			return 1;
		}
		if(n == 0) {
			return 1;
		}
		if(n < 0) {
			x = 1 / x;
			n = -n;
		}

		if(n%2 == 0) {
			return myPow(x * x , n / 2);
		} else {
			return x*myPow(x * x , n / 2);
		}
	}

}
