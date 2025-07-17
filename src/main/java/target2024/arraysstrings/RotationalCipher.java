package target2024.arraysstrings;

//https://www.metacareers.com/profile/coding_practice_question/?problem_id=238827593802550&c=1373057600385980&psid=275492097255885&practice_plan=0&b=0111122
public class RotationalCipher {
	public static void main(String[] args) {
		RotationalCipher rc = new RotationalCipher();
		String input = "Zebra-493?";
		int rotationFactor = 3;
		System.out.println(rc.rotationalCipher(input, rotationFactor));
	}

	String rotationalCipher(String input, int rotationFactor) {
		int rfChar = rotationFactor % 26; // Rotation factor for letters
		int rfInt = rotationFactor % 10;  // Rotation factor for digits
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			if (ch >= 'A' && ch <= 'Z') {
				// Rotate uppercase letters
				char rotated = (char) ('A' + (ch - 'A' + rfChar) % 26);
				result.append(rotated);
			} else if (ch >= 'a' && ch <= 'z') {
				// Rotate lowercase letters
				char rotated = (char) ('a' + (ch - 'a' + rfChar) % 26);
				result.append(rotated);
			} else if (ch >= '0' && ch <= '9') {
				// Rotate digits
				char rotated = (char) ('0' + (ch - '0' + rfInt) % 10);
				result.append(rotated);
			} else {
				// Leave other characters unchanged
				result.append(ch);
			}
		}

		return result.toString();
	}
}
