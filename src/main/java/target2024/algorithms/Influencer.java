package target2024.algorithms;

/**
 * Given a matrix of following relationships between N LinkedIn users (with ids from 0 to N-1):
 * following_matrix[i][j] == True if user i is following user j
 * thus following_matrix[i][j] doesn't imply following_matrix[j][i].
 * Assume following_matrix[i][i] == False.
 *
 * An influencer is a user who is:
 * - Followed by everyone else, and
 * - Not following anyone themselves.
*/

public class Influencer {
	public static void main(String[] args) {
		boolean[][] matrix = {
				{false, true, true, true},
				{true, false, true, false},
				{false, false, false, false},
				{false, false, true, false}
		};

		System.out.println(getInfluencer(matrix));
	}

	private static int getInfluencer(boolean[][] matrix) {
		//2 pointer strategy
		//2 loops with hashSet
		return 2;
	}
}
