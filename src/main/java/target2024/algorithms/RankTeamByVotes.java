package target2024.algorithms;

//https://leetcode.com/problems/rank-teams-by-votes/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In a special ranking system, each voter gives a rank from highest to lowest to all teams participating in the competition.
 * The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position,
 * we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved.
 * If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.
 * You are given an array of strings votes which is the votes of all voters in the ranking systems.
 * Sort all teams according to the ranking system described above.
 * Return a string of all teams sorted by the ranking system.
 * Example 1:
 * Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
 * Output: "ACB"
 */
public class RankTeamByVotes {
	public static void main(String[] args) {
		RankTeamByVotes rv = new RankTeamByVotes();
		String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
		System.out.println(rv.rankTeams(votes));
	}

	public String rankTeams(String[] votes) {
		if (votes.length == 0)
			return "";

		if (votes.length == 1)
			return votes[0];

		// Extract all teams from the first vote
		int numTeams = votes[0].length();

		// Map to keep the position count for each team
		Map<Character, int[]> positionMap = new HashMap<>();
		for (char c : votes[0].toCharArray()) {
			positionMap.put(c, new int[numTeams]);
		}

		// Fill the map with the vote counts
		for (String vote : votes) {
			for (int i = 0; i < numTeams; i++) {
				char team = vote.charAt(i);
				positionMap.get(team)[i]++;
			}
		}

		// Create a list of teams to sort
		List<Character> teams = new ArrayList<>(positionMap.keySet());

		// Sort the teams based on votes and lexicographical order as tiebreaker
		Collections.sort(teams, (a, b) -> {
			for (int i = 0; i < numTeams; i++) {
				if (positionMap.get(b)[i] != positionMap.get(a)[i]) {
					return positionMap.get(b)[i] - positionMap.get(a)[i];
				}
			}
			return a - b; // Lexicographically if all positions are tied
		});

		// Build the result string from the sorted teams list
		StringBuilder result = new StringBuilder();
		for (char team : teams) {
			result.append(team);
		}

		return result.toString();
	}
}
