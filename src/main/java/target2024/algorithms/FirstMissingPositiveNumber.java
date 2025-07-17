package target2024.algorithms;

public class FirstMissingPositiveNumber {
	public static void main(String[] args) {
		int[] arr = {3,4,-1,1,7,8,9,11,12,1};
		System.out.println(firstMissingPositive(arr));
	}

	public static int firstMissingPositive(int[] nums) {
		int result; //2

		// int size = Integer.MAX_VALUE;
		int size = 100001;
		int[] indArr = new int[size];

		for(int i=0; i<indArr.length; i++) {
			indArr[i] = -1;
		}

		for(int i=0; i<nums.length; i++) {
			if((nums[i] > 0) && (nums[i] < size)) {
				indArr[nums[i]] = i;
			}
		}

		for(int i=1; i<indArr.length; i++) {
			if(indArr[i] == -1) {
				System.out.println("First positive number = " + i);
				return i;
			}
		}
		return 100001;
	}
}
