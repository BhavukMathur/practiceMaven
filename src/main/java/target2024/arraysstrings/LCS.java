package target2024.arraysstrings;

public class LCS {
	public static void main(String[] args) {
		String str1 = "acdacd";
		String str2 = "abcd";

		System.out.println(lcsRecursion(str1, str2, 0, 0));

		int[][] arr = new int[str1.length()][str2.length()];
		for(int i=0; i<str1.length(); i++) {
			for(int j=0; j<str2.length(); j++) {
				arr[i][j] = 0;
			}
		}
		System.out.println(lcsDP(str1, str2, 0, 0, arr));
	}

	private static int lcsRecursion(String str1, String str2, int i, int j) {
		if(i >= str1.length())
			return 0;

		if(j >= str2.length())
			return 0;

		if(str1.charAt(i) == str2.charAt(j)) {
			return 1 + lcsRecursion(str1, str2, i+1, j+1);
		} else {
			return Math.max(lcsRecursion(str1, str2, i+1, j), lcsRecursion(str1, str2, i, j+1));
		}
	}

	private static int lcsDP(String str1, String str2, int i, int j, int[][] arr) {
		if(i >= str1.length())
			return 0;

		if(j >= str2.length())
			return 0;

		if(arr[i][j] != 0) {
			return arr[i][j];
		}

		if (str1.charAt(i) == str2.charAt(j)) {
			arr[i][j] = 1 + lcsDP(str1, str2, i + 1, j + 1, arr);
		} else {
			arr[i][j] = Math.max(lcsDP(str1, str2, i + 1, j, arr), lcsDP(str1, str2, i, j + 1, arr));
		}

		return arr[i][j];
	}
}
