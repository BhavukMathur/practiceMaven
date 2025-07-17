package target2024.arraysstrings;

public class ProductOfFirstKNumbers {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 5, 4};
		int lastZeroIndex = -1;
		int k = 5;
		int len = arr.length;

		int[] productArr = new int[len];
		if(arr[0] == 0) {
			lastZeroIndex = 0;
			productArr[0] = 1;
		} else {
			productArr[0] = arr[0];
		}

		for(int i = 1; i < len; i++) {
			if(arr[i] == 0) {
				productArr[i] = 1;
				lastZeroIndex = i;
			} else {
				productArr[i] = arr[i] * productArr[i-1];
			}
		}

		System.out.println("Main Array");
		for(int i=0; i<len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\nProduct Array");
		for(int i=0; i<len; i++) {
			System.out.print(productArr[i] + " ");
		}

		if(lastZeroIndex >= (len - k)) {
			System.out.println("\nProduct of last " + k + " = 0");
		} else {
			System.out.println("\nProduct of last " + k + " = " + productArr[len - 1] / productArr[len - 1 - k]);
		}
	}
}
