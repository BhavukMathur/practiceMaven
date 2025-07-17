package target2024.binarySearch;

public class RotBinarySearch {
	public static void main(String[] args) {
		int[] arr = {4,5,6,7,0,1,2};
		int x = 0;

		int ind = rotBinarySearch(arr, x, 0, arr.length-1);
		System.out.println("Value " + x + " found at index=" + ind);
	}

	public static int rotBinarySearch(int[] arr, int x, int left, int right) {
		if (left > right) {
			return -1;
		}

		int mid = (right + left) / 2;

		if (arr[mid] == x) {
			return mid;
		}

		// Check if the left half is sorted
		if (arr[left] <= arr[mid]) {
			// If x is in the range of the sorted left half
			if (x >= arr[left] && x <= arr[mid]) {
				return rotBinarySearch(arr, x, left, mid - 1);
			} else {
				return rotBinarySearch(arr, x, mid + 1, right);
			}
		}

		// If the right half is sorted
		if (x >= arr[mid] && x <= arr[right]) {
			return rotBinarySearch(arr, x, mid + 1, right);
		} else {
			return rotBinarySearch(arr, x, left, mid - 1);
		}
	}
}
