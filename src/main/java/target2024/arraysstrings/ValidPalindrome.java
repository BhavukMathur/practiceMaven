package target2024.arraysstrings;

/**
 * https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ValidPalindrome {
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		String str = "A man, a plan, a canal: Panama";
		System.out.println(vp.isPalindrome(str));
	}

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int left=0, right=s.length()-1;
		char lchar, rchar;
		while(left < right) {
			lchar = s.charAt(left);
			rchar = s.charAt(right);

			if(!Character.isLetterOrDigit(lchar)) {
				left++;
				continue;
			}
			if(!Character.isLetterOrDigit(rchar)) {
				right--;
				continue;
			}
			if(lchar != rchar) {
				return false;
			} else {
				left++;
				right--;
			}
		}
		return true;
	}
}
