package target2024.arraysstrings;

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {
		int arr[] = {0, 1, 2, 3, 4, 5};
		int n = 2; //Rotate to right

		System.out.println(Arrays.toString(arr));
		int[] result = rotate(arr, n);
		System.out.println(Arrays.toString(result));

		//Without using extra space

	}

	/**
		 Normalize k: If k is greater than the length of the array, calculate k % array_length.
		 Reverse the entire array.
		 Reverse the first k elements.
		 Reverse the remaining array_length - k elements.
	 */
	private static int[] rotateOpt(int[] arr, int n) {
		//{0, 1, 2, 3, 4, 5};
		//{5, 4, 3, 2, 1, 0};
		//{4, 5, 3, 2, 1, 0};
		//{4, 5, 0, 1, 2, 3}
		return null;
	}


	private static int[] rotate(int[] arr, int n) {
		int[] result = new int[arr.length];

		n = n % arr.length;

		for(int i=0; i<arr.length; i++) {
			result[i] = arr[(i+n)%arr.length];
		}
		return result;
	}
}
