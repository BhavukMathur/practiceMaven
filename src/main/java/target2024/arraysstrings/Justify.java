package target2024.arraysstrings;

public class Justify {
	public static void main(String[] args) {
		justify(25, "This is some sample text, really just enough to generate a few lines in the output\n" +
				"to show what the text justify function is supposed to do.");
	}

	private static void justify(int len, String str) {
		String[] sarr = str.split(" ");
//		for(int i=0; i<sarr.length; i++) {
//			System.out.println(sarr[i]);
//		}

		int lenSoFar;
		for(int i=0; i<sarr.length;) {
			lenSoFar = 0;

			//Modify to get the length of the next element
			while(lenSoFar <= len && i < sarr.length) {
				System.out.print(sarr[i] + " ");
				lenSoFar = lenSoFar + sarr[i].length();
				i++;
			}
			System.out.println();
		}
	}
}
