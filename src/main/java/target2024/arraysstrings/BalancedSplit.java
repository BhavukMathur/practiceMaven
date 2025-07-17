package target2024.arraysstrings;

import java.util.Arrays;

public class BalancedSplit {
	public static void main(String[] args) {
		BalancedSplit bs = new BalancedSplit();
		int[] arr = {1, 5, 7, 1};
		System.out.println(bs.balancedSplitExists(arr));
	}

	boolean balancedSplitExists(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
		}

		Arrays.sort(arr);
		int halfSum = 0;
		for(int i=0; i<arr.length; i++) {
			halfSum = halfSum + arr[i];
			if(halfSum == (sum / 2)) {
				if(arr[i] == arr[i+1]) {
					return false;
				}
				return true;
			} else if(halfSum > (sum/2)) {
				return false;
			}
		}
		return false;
	}
}
