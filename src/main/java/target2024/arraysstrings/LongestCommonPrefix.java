package target2024.arraysstrings;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] sarr = {"flower","flow","flight"};
		System.out.println(lcp.longestCommonPrefix(sarr));
	}

	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		}
		if(strs.length == 1) {
			return strs[0];
		}

		String s1, s2, pfx = strs[0];
		for(int i=1; i<strs.length; i++) {
			s1 = pfx;
			s2 = strs[i];
			pfx = findCommon(s1, s2);
			if(pfx.equals("")) {
				return "";
			}
		}
		return pfx;
	}

	public String findCommon(String s1, String s2) {
		char[] pfx = new char[Math.min(s1.length(), s2.length())];
		for(int i=0; i<s1.length() && i<s2.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				pfx[i] = s1.charAt(i);
			} else {
				if(i == 0) {
					return "";
				}
				pfx[i] = '\0';
				return new String(pfx).substring(0, i);
			}
		}
		return new String(pfx);
	}
}
