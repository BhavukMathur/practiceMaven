package target2024.dynamicProgramming;

//0, 1, 1, 2, 3, 5, 8, 13
public class Fibonacci {
	public static void main(String[] args) {
		Fibonacci fb = new Fibonacci();
		int num = 30;
		System.out.println(fb.fib(num));
	}

	public int fib(int n) {
		int[] arr = new int[31];
		arr[0] = 0;
		arr[1] = 1;

		for(int i=2; i<=n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
	}

	public int fib1(int n) {
		int[] arr = new int[31];
		for(int i=0; i<arr.length; i++) {
			arr[i] = -1;
		}
		return fib1(n, arr);
	}

	private int fib1(int n, int[] arr) {
		if(n < 0) {
			return 0;
		}
		if(n == 0) {
			arr[n] = 0;
			return 0;
		}
		if(n == 1) {
			arr[n] = 1;
			return 1;
		}
		if(arr[n] != -1) {
			return arr[n];
		}
		arr[n] = (fib1(n-1) + fib1(n-2));
		return arr[n];
	}

}
