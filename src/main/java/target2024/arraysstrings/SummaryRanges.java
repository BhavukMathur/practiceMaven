package target2024.arraysstrings;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public static void main(String[] args) {
		SummaryRanges sr = new SummaryRanges();
		int[] nums = {0,2,3,4,6,8,9,11};
//		int[] nums = {0,1,2,4,5,7};
		System.out.println(sr.summaryRanges(nums));
	}

	public List<String> summaryRanges(int[] nums) {
		//0,1,2,4,5,7]
		//"0->2","4->5","7"

		//{0,2,3,4,6,8,9};
		//["0","2->4","6","8->9"]

		List<String> result = new ArrayList<>();
		if(nums.length == 0) {
			return result;
		}

		int i=0, j=i+1;

		while(j<nums.length) {
			if(nums[j] == (nums[j-1]+1)) {
				j++;
			} else {
				if((j-1) == i) {
					result.add(String.valueOf(nums[i]));
					i = j;
					j = j+1;
				} else {
					result.add(nums[i] + "->" + nums[j-1]);
					i = j;
					j++;
				}
			}
		}

		if((j-1) == i) {
			result.add(String.valueOf(nums[i]));
		} else {
			result.add(nums[i] + "->" + nums[j-1]);
		}
		return result;
	}

}
