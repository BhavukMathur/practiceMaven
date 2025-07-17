package target2024.arraysstrings;

import java.util.Arrays;
import java.util.Stack;

//https://www.metacareers.com/profile/coding_practice_question/?problem_id=226517205173943&c=1373057600385980&psid=275492097255885&practice_plan=0&b=0111122
public class ContiguousSubArrays {
	public static void main(String[] args) {
		int[] arr = {3, 4, 1, 6, 2};
//		output = [1, 3, 1, 5, 1]

		System.out.println(Arrays.toString(arr));
		ContiguousSubArrays cs = new ContiguousSubArrays();
		System.out.println(Arrays.toString(cs.countSubarraysBrute(arr)));
		System.out.println(Arrays.toString(cs.countSubarrays(arr)));
	}

	int[] countSubarrays(int[] arr) {
		int n = arr.length;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] result = new int[n];

		// Stack to keep the indices of the elements
		Stack<Integer> stack = new Stack<>();

		// Calculate left distances
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				stack.pop();
			}
			left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
			stack.push(i);
		}

		// Clear the stack for the right calculation
		stack.clear();

		// Calculate right distances
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				stack.pop();
			}
			right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
			stack.push(i);
		}

		// Calculate result by adding left and right distances
		for (int i = 0; i < n; i++) {
			result[i] = left[i] + right[i] - 1;
		}
		return result;
	}

	int[] countSubarraysBrute(int[] arr) {
		int[] result = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			int count = 1;
			int j;
			//Check left side
			for(j=i-1; j>=0;) {
				if(arr[i] > arr[j]) {
					j--;
				} else {
					break;
				}
			}
			count = count + (i - j) - 1;

			//Check right side
			for(j=i+1; j<arr.length;) {
				if(arr[i] > arr[j]) {
					j++;
				} else {
					break;
				}
			}
			count = count + (j-i) - 1;
			result[i] = count;
		}
		return result;
	}
}
