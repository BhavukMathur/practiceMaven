package target2024.arraysstrings;

public class StringSpecifics {
	public static void main(String[] args) {
		String str = "You can do it. you have to do it";
		String[] sarr = str.split(" ");
		String str2 = new String(str);
		System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode(str2));
		StringBuilder sbr = new StringBuilder(str);
		System.out.println(sbr);

		String aa = "abcdeaade";
		String ee = "def";
		System.out.println(aa.indexOf(ee));

	}
}
