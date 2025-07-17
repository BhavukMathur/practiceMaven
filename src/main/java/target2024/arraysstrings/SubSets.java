package target2024.arraysstrings;

import java.util.LinkedList;
import java.util.List;

public class SubSets {
	public static void main(String[] args) {
		SubSets subSets = new SubSets();
		int[] nums = {1,2,3};
		List<List<Integer>> result = subSets.subsets(nums);
		for(List<Integer> list: result) {
			for(Integer val: list) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		result.add(new LinkedList<>());

		for(int val: nums) {
			int size = result.size();
			for(int i=0; i<size; i++) {
				List<Integer> listSoFar = new LinkedList(result.get(i)); //Creating a copy of the existing list
				listSoFar.add(val);
				result.add(listSoFar);
			}
		}
		return result;
	}
}
