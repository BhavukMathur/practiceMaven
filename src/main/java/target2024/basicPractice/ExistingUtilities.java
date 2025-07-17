package target2024.basicPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExistingUtilities {
	public static void main(String[] args) {
		int[] arr = {3, 5, 1, 4, 2};
		Arrays.sort(arr);
		System.out.println(Arrays.binarySearch(arr, 5));
//		Integer[] arr2 = {3, 5, 1, 4, 2};
		List list = Arrays.asList(arr);
		ArrayList arrayList = new ArrayList();
		for(int i=0; i<arr.length; i++) {
			arrayList.add(arr[i]);
		}
		System.out.println(arrayList);
		System.out.println(arrayList.indexOf(3));
	}
}
