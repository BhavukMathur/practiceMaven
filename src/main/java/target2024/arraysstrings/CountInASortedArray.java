package target2024.arraysstrings;

public class CountInASortedArray {
	public static void main(String[] args) {
		int[] arr = {10, 10, 20, 20, 20, 20, 20, 30, 40, 40};
		int x = 20;
		int leftMost = findCount(arr, x, 0, arr.length-1);
		int rightMost = findCount(arr, x, 0, arr.length-1);
		System.out.println("Occurences of x=" + (rightMost - leftMost));
	}

	public static int findCount(int[] arr, int x, int left, int right) {
		return -1;
	}
}
