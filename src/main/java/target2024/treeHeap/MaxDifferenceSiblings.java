package target2024.treeHeap;

public class MaxDifferenceSiblings {
	static Integer maxDiff = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Integer[] arr = {100, 50, 105, 5, 75, 102, 106, null, null, 60, null, 101, null};

		updateMaxDiff(arr, 0);
		System.out.println(maxDiff);
	}

	private static void updateMaxDiff(Integer[] arr, int root) {
		if(root >= arr.length) {
			return;
		}

		int leftInd = 2*root + 1;
		int rightInd = 2*root + 2;

		if(leftInd < arr.length && arr[leftInd] != null
		&& rightInd < arr.length && arr[rightInd] != null) {
			int localDiff = arr[rightInd] - arr[leftInd];
			if(localDiff > maxDiff) {
				maxDiff = localDiff;
				System.out.println(arr[root] + " " + arr[leftInd] + " " + arr[rightInd]);
			}
		}
		updateMaxDiff(arr, leftInd);
		updateMaxDiff(arr, rightInd);
	}
}
