package target2024.binarySearch;

//https://leetcode.com/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-interview-150
public class BinarySearchInsertion {
	public static void main(String[] args) {
		BinarySearchInsertion bsi = new BinarySearchInsertion();
		int[] nums = {1,3,5,6}; //4
		int target = 7;

//		System.out.println(target + "\t" + bsi.searchInsert(nums, target));
		for(int i=0; i<11; i++) {
			System.out.println(i + "\t" + bsi.searchInsert(nums, i));
		}
	}

	public int searchInsert(int[] nums, int target) {
		return searchInsertRecursive(nums, target, 0, nums.length-1);
	}

	public int searchInsertRecursive(int[] nums, int target, int left, int right) {
		if(right >= nums.length) {
			return left;
		}
		if(left < 0) {
			return left;
		}
		if(left > right) {
			return left;
		}
		if(left == right) {
			if(nums[left] == target) {
				return left;
			} else if(nums[left] > target) {
				return left;
			} else {
				return left+1;
			}
		}

		int mid = (left + right) / 2;
		if(nums[mid] == target) {
			return mid;
		}

		if(nums[mid] < target) {
			return searchInsertRecursive(nums, target, mid+1, right);
		} else {
			return searchInsertRecursive(nums, target, left, mid);
		}
	}
}
