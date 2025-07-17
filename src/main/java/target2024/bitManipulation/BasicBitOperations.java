package target2024.bitManipulation;

public class BasicBitOperations {
	public static void main(String[] args) {
		int num = 10;
		System.out.println(num);
		System.out.println(Integer.toBinaryString(num));
		System.out.println(num >> 1); 		//Divide by 2
		System.out.println(num << 1); 		//Multiply by 2
		System.out.println(num % 3);
	}
}
