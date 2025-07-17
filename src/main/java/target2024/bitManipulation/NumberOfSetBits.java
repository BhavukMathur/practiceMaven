package target2024.bitManipulation;

public class NumberOfSetBits {
	public static void main(String[] args) {
		NumberOfSetBits nsb = new NumberOfSetBits();
		int n = 11;
		//1011
		System.out.println(nsb.hammingWeight(n));
	}

	public int hammingWeight(int n) {
		int count = 0;

		while(n != 0) {
			if((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}
}
