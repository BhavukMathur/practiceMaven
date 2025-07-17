package target2024.algorithms;

public class ClosestPairSum {
	public static void main(String[] args) {
		int[] arr = {1, 4, 5, 7, 11, 14, 19, 29};
		int[] brr = {10, 20, 34, 40};
		int sum = 32;

		int finalMinDiff = Integer.MAX_VALUE;
		int temp=0;
		int afinal=0, bfinal=0;
		int diff;
		int i=0;
		int j=brr.length-1;

		while(i < arr.length && j>=0) {
			temp = arr[i] + brr[j];
			diff = Math.abs(sum - temp);

			if(diff < finalMinDiff) {
				finalMinDiff = diff;
				afinal = arr[i];
				bfinal = brr[j];
			}

			if(temp > sum) {
				j--;
			}
			else if (temp < sum) {
				i++;
			}
			else {
				//Equal
				break;
			}
		}

		System.out.println("Closest sum=" + (afinal + bfinal) + " with numbers as " + afinal + " " + bfinal);
	}
}
