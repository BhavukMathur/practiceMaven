package target2024.arraysstrings;

public class NumberPalindrome {
	public static void main(String[] args) {
		NumberPalindrome np = new NumberPalindrome();
		System.out.println(np.isPalindrome(13464431));
	}
	public boolean isPalindrome(int x) {
		String str = String.valueOf(x);
		int len = str.length();
		//1346431 --> 7
		for(int i=0; i<len/2; i++) {
			if(str.charAt(i) != str.charAt(len-1-i)) {
				return false;
			}
		}
		return true;
	}
}
