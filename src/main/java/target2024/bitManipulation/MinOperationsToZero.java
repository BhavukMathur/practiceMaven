package target2024.bitManipulation;

//Number of operations to reduce x to 0 by adding or subtracting 2^i
//Eg --> 7 + 2^0 = 8 (1)
// 8 - 2^3 = 0 (2 operations)
public class MinOperationsToZero {
	public static void main(String[] args) {
		int n = 7;
		System.out.println("Minimum operations to reduce " + n + " to 0: " + minOperations(n));
	}

	public static int minOperations(int n) {
		int operations = 0;

		int temp = n;
		while (temp != 0) {
			// If n is even, we can divide by 2 (which is like undoing a 2^i move)
			if ((temp % 2) == 0) {
				temp = temp / 2;
			} else {
				temp = addOrSubtract(temp);
				operations++;
			}
		}
		return operations;
	}

	private static int addOrSubtract(int n) {
		if((n & 2) != 0) {
			return n + 1;
		} else {
			return (n - 1);
		}
	}
}
