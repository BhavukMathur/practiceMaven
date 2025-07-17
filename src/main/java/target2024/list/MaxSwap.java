package target2024.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MaxSwap {
	public static void main(String[] args) {
		System.out.println(maximumSwap(1993));
	}

	public static int maximumSwap(int num) {
		List<Integer> original = new ArrayList<>();

		String temp = String.valueOf(num);
		for(int i=0; i<temp.length(); i++) {
			original.add(Integer.valueOf(temp.charAt(i) - '0'));
		}
		System.out.println(original);
		List<Integer> sorted = new ArrayList<>(original);
		Collections.sort(sorted, Collections.reverseOrder());
		System.out.println(sorted);

		//72736
		//77632
		int swapLeft=0, swapRight=0, swapVal = -1;
		for(int i=0; i<original.size(); i++) {
			if(original.get(i) == sorted.get(i)) {
				//Do nothing, already in place
			} else {
				swapLeft = i;
				swapVal = sorted.get(i);
				break;
			}
		}

		int tempInt;
		if(swapVal != -1) {
			for(int i=swapLeft; i<original.size(); i++) {
				if(original.get(i) == swapVal) {
					//FIX: Largest number on right which is lesser than swapVal, not the mismatch
					swapRight = i;
					break;
				}
			}

			System.out.println("To swap: " + swapLeft + " : " + swapRight);

			// Swap the elements at indices swapLeft and swapRight in the original list
			tempInt = original.get(swapLeft);
			original.set(swapLeft, original.get(swapRight));
			original.set(swapRight, tempInt);

			int result = 0;

			for(int i=0; i<original.size(); i++) {
				result = result * 10;
				result = result + original.get(i);
			}
			return result;
		} else {
			return num;
		}
	}

}
