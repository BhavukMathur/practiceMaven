package target2024.arraysstrings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SumOfTwoNumbersDivisibleBy60 {
	public static void main(String[] args) {
		SumOfTwoNumbersDivisibleBy60 st = new SumOfTwoNumbersDivisibleBy60();
		int[] time = {30,20,150,100,40};
		System.out.println(st.numPairsDivisibleBy60(time));
	}

	public int numPairsDivisibleBy60(int[] time) {
		int count = 0;

		//Instead of a list, we can maintain the count only as value and do the calculation
		Map<Integer, List<Integer>> indMap = new HashMap<>();

		int temp;
		for(int i=0; i<time.length; i++) {
			temp = time[i] % 60;
			if(indMap.get(temp) == null) {
				List<Integer> indList = new LinkedList<>();
				indList.add(i);
				indMap.put(temp, indList);
			} else {
				List<Integer> indList = indMap.get(temp);
				indList.add(i);
				indMap.put(temp, indList);
			}
		}

		//Iterate over the hashMap and handle 30 specifically
		int m, n;
		for(Map.Entry<Integer, List<Integer>> entry: indMap.entrySet()) {
			if(entry.getKey() == 30 || entry.getKey() == 0) {
				m = entry.getValue().size();
				if(m > 1) {
					count = count + calculatePermutation(m);
				}
			} else {
				int key = entry.getKey();
				if(indMap.get(60 - key) != null) {
					m = entry.getValue().size();
					n = indMap.get(60 - key).size();
					count = count + (m * n);
				}
			}
		}
		count = count / 2;
		return count;
	}

	public int calculatePermutation(int n) {
		int temp = factorial(n - 2);
		return (n * (n-1) * temp) / temp;
	}

	private int factorial(int num) {
		int result = 1;
		for (int i = 1; i <= num; i++) {
			result *= i;
		}
		return result;
	}
}
