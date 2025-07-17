package target2024.binarySearch;

//Count of x in a sorted array
public class CountInASortedArray {
	public static void main(String[] args) {
		int[] arr = {10, 10, 20, 20, 20, 20, 20, 30, 30, 40, 50, 50};
		int x = 20;

		int randomIndex = binarySearch(arr, x, 0, arr.length - 1);
		System.out.println(randomIndex);

		int leftMostIndex = binarySearchLeft(arr, x, 0, arr.length - 1);
		System.out.println(leftMostIndex);

		int rightMostIndex = binarySearchRight(arr, x, 0, arr.length - 1);
		System.out.println(rightMostIndex);

		System.out.println("Count of x:" + x + " =" + (rightMostIndex - leftMostIndex + 1));
	}

	public static int binarySearchLeft(int[] arr, int x, int left, int right) {
		if(left < 0 || right > arr.length || left > right) {
			return -1;
		}

		if(left == right) {
			return left;
		}

		if((right - left) == 1) {
			if(arr[left] == x) {
				return left;
			}
			return right;
		}

		int mid = (right + left) / 2;
		if(arr[mid] >= x) {
			return binarySearchLeft(arr, x, left, mid);
		} else {
			return binarySearchLeft(arr, x, mid+1, right);
		}
	}

	public static int binarySearchRight(int[] arr, int x, int left, int right) {
		if(left < 0 || right > arr.length || left > right) {
			return -1;
		}

		if(left == right) {
			return left;
		}

		if((right - left) == 1) {
			if(arr[right] == x) {
				return right;
			}
			return left;
		}

		int mid = (right + left) / 2;
		if(arr[mid] > x) {
			return binarySearchRight(arr, x, left, mid);
		} else {
			return binarySearchRight(arr, x, mid+1, right);
		}
	}

	public static int binarySearch(int[] arr, int x, int left, int right) {
		if(left < 0 || right > arr.length || left > right) {
			return -1;
		}

		int mid = (right + left) / 2;
		if(arr[mid] == x) {
			return mid;
		}
		//Traverse left
		if(arr[mid] > x) {
			return binarySearch(arr, x, left, mid);
		} else {
			return binarySearch(arr, x, mid+1, right);
		}
	}
}
