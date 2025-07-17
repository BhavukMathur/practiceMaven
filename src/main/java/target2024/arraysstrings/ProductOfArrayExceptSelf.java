package target2024.arraysstrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
public class ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		ProductOfArrayExceptSelf ps = new ProductOfArrayExceptSelf();
		int[] arr = {-1,1,0,-3,3};
		System.out.println(Arrays.toString(ps.productExceptSelf(arr)));
	}

	public int[] productExceptSelf(int[] nums) {
		int[] brr = new int[nums.length];
		int totalProduct = 1;
		Set<Integer> zeroIndex = new HashSet<>();
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 0) {
				zeroIndex.add(i);
				nums[i] = 1;
			}
			totalProduct = totalProduct * nums[i];
		}

		if(zeroIndex.size() == 0) {
			for(int i=0; i<brr.length; i++) {
				brr[i] = totalProduct / nums[i];
			}
		} else if(zeroIndex.size() == 1) {
			Arrays.fill(brr, 0);
			int finalTotalProduct = totalProduct;
			zeroIndex.forEach(val -> {
				brr[val] = finalTotalProduct;
			});
		} else {
			Arrays.fill(brr, 0);
		}
		return brr;
	}
}
