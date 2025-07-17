package target2024.binarySearch;

//https://leetcode.com/problems/single-element-in-a-sorted-array/description/?envType=company&envId=coupang&favoriteSlug=coupang-all
public class SingleElementSortedArray {
	//Mid search and even odd size of left and right
	public static void main(String[] args) {
		SingleElementSortedArray se = new SingleElementSortedArray();
		int[] arr = {1,1,2,3,3,4,4,8,8};
		System.out.println(se.singleNonDuplicate(arr));
	}

	public int singleNonDuplicate(int[] nums) {
		return singleNonDuplicate(nums, 0, nums.length-1);
	}

	public int singleNonDuplicate(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		}

		int mid = (right + left) / 2;

		// Ensure mid is even
		if (mid % 2 == 1) {
			mid--;
		}

		if (nums[mid] != nums[mid + 1]) {
			// Single element is on the left side
			return singleNonDuplicate(nums, left, mid);
		} else {
			// Single element is on the right side
			return singleNonDuplicate(nums, mid + 2, right);
		}
	}

}
