package target2024.arraysstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
	public static void main(String[] args) {
//		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//		int[] newInterval = {4,8};
//		int[][] intervals = {{1,3},{6,9}};
//		int[] newInterval = {2,5};
//		int[][] intervals = {};
//		int[] newInterval = {2,5};
		int[][] intervals = {{1, 5}};
		int[] newInterval = {2,3};
		int[][] result = insert(intervals, newInterval);

		for(int i=0; i<result.length; i++) {
			System.out.print(result[i][0] + " : " + result[i][1]);
			System.out.println();
		}
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		// List to store the resulting intervals
		List<int[]> result = new ArrayList<>();

		// Index to navigate the original intervals
		int i = 0;

		// Step 1: Add all intervals that end before the new interval begins
		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i]);
			i++;
		}

		// Step 2: Merge all overlapping intervals with the new interval
		while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}
		result.add(newInterval); // Add the merged interval

		// Step 3: Add the remaining intervals
		while (i < intervals.length) {
			result.add(intervals[i]);
			i++;
		}

		// Convert result list to array and return
		return result.toArray(new int[result.size()][]);
	}

}
