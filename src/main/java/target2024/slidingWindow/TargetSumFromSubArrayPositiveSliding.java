package target2024.slidingWindow;

//Only positive numbers
public class TargetSumFromSubArrayPositiveSliding {
	public static void main(String[] args) {
		int[] arr = {2, 6, 0, 9, 7, 3, 1, 4, 1, 10};
		int sum = 15;

		int start=0, end=0, tempSum = arr[0];
		for(int i=0, j=0; i<arr.length && j<arr.length;) {
			if(tempSum == sum) {
				start = i;
				end = j;
				break;
			} else if (tempSum < sum) {
				j++;
				tempSum = tempSum + arr[j];
			} else if (tempSum > sum) {
				tempSum = tempSum - arr[i];
				i++;
			}
		}

		if(tempSum == sum) {
			System.out.println("Subarray found - " + start + " " + end);
		} else {
			System.out.println("Not found");
		}
	}
}
