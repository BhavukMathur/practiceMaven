package target2024.bitManipulation;

import java.util.Arrays;

public class NextHigherSameBits {
	public static void main(String[] args) {
		int num = 156;
		String numStr = Integer.toBinaryString(num);
		System.out.println(numStr);

		int i=0;
		for(i=numStr.length()-1; i>=1;) {
			if(numStr.charAt(i) <= numStr.charAt(i-1)) {
				i--;
			} else {
				break;
			}
		}

		char[] chArr = numStr.toCharArray();
		chArr[i] = '0';
		chArr[i-1] = '1';

		Arrays.sort(chArr, i, numStr.length());
		System.out.println(chArr);

		String newStr = new String(chArr);
		Integer newInt = Integer.parseInt(newStr, 2);
		System.out.println("Next higher number = " + newInt);
	}
}
