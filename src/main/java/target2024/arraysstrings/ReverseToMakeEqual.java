package target2024.arraysstrings;

import java.util.HashMap;
import java.util.Map;

//https://www.metacareers.com/profile/coding_practice_question/?problem_id=2869293499822992&c=1373057600385980&psid=275492097255885&practice_plan=0&b=0111122
//https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/
public class ReverseToMakeEqual {
	public static void main(String[] args) {
		ReverseToMakeEqual re = new ReverseToMakeEqual();
		int[] arr = {1,2,3,4};
		int[] brr = {2,4,1,3};
		System.out.println(re.canBeEqual(arr, brr));
	}

	public boolean canBeEqual(int[] target, int[] arr) {
		if(target.length != arr.length) {
			return false;
		}
		Map<Integer, Integer> targetCount = new HashMap();
		Map<Integer, Integer> arrCount = new HashMap<>();

		for(int i=0; i<target.length; i++) {
			updateMap(targetCount, target[i]);
			updateMap(arrCount, arr[i]);
		}
		return targetCount.equals(arrCount);
	}

	void updateMap(Map<Integer, Integer> hashMap, int val) {
		if(hashMap.get(val) == null) {
			hashMap.put(val, 1);
		} else {
			hashMap.put(val, hashMap.get(val) + 1);
		}
	}

}
