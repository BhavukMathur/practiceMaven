package target2024.arraysstrings;

public class StringAbbrevation {
	public static void main(String[] args) {
		String str = "substitution";
		String abbr = "s10n";
		System.out.println(isValidAbbrevation(str, abbr));
	}

	private static boolean isValidAbbrevation(String str, String abbr) {
		int count = Integer.valueOf(abbr.substring(1, abbr.length()-1));
		System.out.println(count);

		//Match the first and last chars first
		if(str.charAt(0) != abbr.charAt(0)) {
			return false;
		}
		if(str.charAt(str.length()-1) != abbr.charAt(abbr.length()-1)) {
			return false;
		}

		int subStrCount = str.substring(1, str.length()-1).length();
		if(subStrCount == count) {
			return true;
		}
		return false;
	}
}
