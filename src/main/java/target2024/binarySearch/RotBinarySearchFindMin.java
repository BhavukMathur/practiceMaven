package target2024.binarySearch;

public class RotBinarySearchFindMin {
	public static void main(String[] args) {
//		int[] nums = {0, 1, 2, 4, 5, 6, 7};
		int[] nums = {4,5,6,7,0,1,2};
		RotBinarySearchFindMin rbs = new RotBinarySearchFindMin();
//		System.out.println(rbs.binarySearch(nums, 0, nums.length - 1, 3));
		System.out.println(rbs.findMin(nums));
	}

	public int binarySearch(int[] nums, int left, int right, int target) {
		if (left < 0 || right >= nums.length) {
			return -1;
		}

		if (left == right) {
			if (nums[left] == target) {
				return left;
			} else {
				return -1;
			}
		}

		int mid = (left + right) / 2;
		if (nums[mid] == target) {
			return mid;
		}

		if (nums[mid] > target) {
			return binarySearch(nums, left, mid, target);
		} else {
			return binarySearch(nums, mid + 1, right, target);
		}
	}

	public int findMin(int[] nums) {
		return findMinBinary(nums, 0, nums.length-1);
	}

	private int findMinBinary(int[] nums, int left, int right) {
		if(right >= nums.length || left < 0) {
			return -1;
		}
		if (left == right) {
			return nums[left];
		}
		if(right - left == 1) {
			return Integer.min(nums[left], nums[right]);
		}

		int mid = (left + right) / 2;

		//Min on the right
		if((nums[mid] > nums[left]) && (nums[mid] > nums[right])) {
			return findMinBinary(nums, mid+1, right);
		}
		//Min on the left
		else if ((nums[mid] < nums[left]) && (nums[mid] < nums[right])) {
			return findMinBinary(nums, left, mid);
		}
		//Min on the left
		else if ((nums[mid] > nums[left]) && (nums[mid] < nums[right])) {
			return findMinBinary(nums, left, mid);
		}
//		//Not possible :/
//		else if ((nums[mid] < nums[left]) && (nums[mid] > nums[right])) {
//
//		}
		return -1;
	}
}

