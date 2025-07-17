package target2024.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchMain {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4, 5};
		int x = 2;
		System.out.println(Arrays.binarySearch(arr, x));

		List<Integer> list = new ArrayList<>();
		list.add(0); list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);

		System.out.println(Collections.binarySearch(list, x));
	}
}
