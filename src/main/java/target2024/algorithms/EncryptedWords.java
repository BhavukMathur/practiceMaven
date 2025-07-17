package target2024.algorithms;

public class EncryptedWords {
	public static void main(String[] args) {
		EncryptedWords ew = new EncryptedWords();
		System.out.println(ew.findEncryptedWord("abcxcba"));
		System.out.println(ew.findEncryptedWord("abcd"));
	}

	String findEncryptedWord(String s) {
		if(s.length() == 0) {
			return "";
		}
		if(s.length() == 1) {
			return s;
		}
		int mid = (s.length()-1)/2;
		if(mid > 0) {
			return (s.charAt(mid)
					+ findEncryptedWord(s.substring(0, mid))
					+ findEncryptedWord(s.substring(mid+1, s.length())));
		}
		return s;
	}
}
