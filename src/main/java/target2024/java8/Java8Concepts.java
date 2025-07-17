package target2024.java8;

import javax.swing.text.IconView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Concepts {
	public static void main(String[] args) {
		String str = "hello world";
		convertAlternateToUpperCase(str);
	}

	static void convertAlternateToUpperCase(String str) {
		StringBuilder sb = new StringBuilder(str);

		for(int i=0; i<sb.length(); i++) {
			if(i%2 == 0) {
				sb.setCharAt(i, (char) (sb.charAt(i) - ('a' - 'A')));
			}
		}
		System.out.println(sb);
	}
}
