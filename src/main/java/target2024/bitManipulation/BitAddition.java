package target2024.bitManipulation;

//https://leetcode.com/problems/add-binary/description/?envType=study-plan-v2&envId=top-interview-150
public class BitAddition {
	public static void main(String[] args) {
		BitAddition ba = new BitAddition();
		//3 + 1
		System.out.println(ba.addBinary("11", "1"));
	}

	public String addBinary(String a, String b) {
		int aa = Integer.parseInt(a, 2);
		int bb = Integer.parseInt(b, 2);
		return Integer.toBinaryString(aa + bb);
	}
}
