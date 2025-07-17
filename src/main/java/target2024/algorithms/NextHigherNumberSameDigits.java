package target2024.algorithms;

import java.util.ArrayList;

public class NextHigherNumberSameDigits {
	public static void main(String args[]) {
		int num = 534976;
		//result= 536479

		String snum = String.valueOf(num);
		System.out.println(snum.length());
		ArrayList<Integer> intList = new ArrayList<>(snum.length());

		for(int i=0; i<snum.length(); i++) {
			intList.add(0);
		}

		int bnum=num;
		for(int i=0; i<snum.length(); i++) {
			intList.set(snum.length() - 1 - i, bnum % 10);
			bnum = bnum / 10;
		}
		System.out.println(intList);

		//Scan from right
		//Continue until a smaller number is not found

		int i;
		for(i=intList.size()-1; i>0; i--) {
			if(intList.get(i-1) > intList.get(i)) {
				//continue the loop
			}
			else {
				break;
			}
		}
		if(i == 0) {
			System.out.println("Array sorted in descending order, not possible");
		}

		/**
		 *
		 Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than the previously traversed digit. For example, if the input number is “534976”, we stop at 4 because 4 is smaller than next digit 9. If we do not find such a digit, then output is “Not Possible”.
		 Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’. For “534976″, the right side of 4 contains “976”. The smallest digit greater than 4 is 6.
		 Swap the above found two digits, we get 536974 in above example.
		 Now sort all digits from position next to ‘d’ to the end of number. The number that we get after sorting is the output. For above example, we sort digits in bold 536974. We get “536479” which is the next greater number for input 534976.
		 */

	}
}
