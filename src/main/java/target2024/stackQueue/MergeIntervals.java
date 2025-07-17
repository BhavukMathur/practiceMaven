package target2024.stackQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Stack;

//https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150


class Pair {
	int start;
	int end;

	public Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class MergeIntervals {
	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] merged = mi.merge(intervals);
		for(int i=0; i<merged.length; i++) {
			System.out.println(Arrays.toString(merged[i]));
		}
	}

	public int[][] merge(int[][] intervals) {
		Stack<Pair> stack = new Stack<>();
//		Stack<int[]> stack = new Stack<>(); Better..

//		Arrays.sort(intervals, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] a, int[] b) {
//				return Integer.compare(a[0], b[0]);
//			}
//		});

		int start, end;
		for(int i=0; i<intervals.length; i++) {
			start = intervals[i][0];
			end = intervals[i][1];

			if(stack.isEmpty()) {
				Pair pair = new Pair(start, end);
				stack.push(pair);
			} else {
				if(start <= stack.peek().end) {
					Pair pair = stack.pop();
					pair.start = Integer.min(pair.start, start);
					pair.end = Integer.max(pair.end, end);
					stack.push(pair);
				} else {
					Pair pair = new Pair(start, end);
					stack.push(pair);
				}
			}
		}

//		//Printing the stack
//		while (!stack.isEmpty()) {
//			Pair pair = stack.pop();
//			System.out.println(pair.start + " : " + pair.end);
//		}

		int[][] result = new int[stack.size()][2];

		int i=stack.size()-1;
		Pair pair;
		while(!stack.isEmpty()) {
			pair = stack.pop();
			result[i][0] = pair.start;
			result[i][1] = pair.end;
			i--;
		}
		return result;
	}

}
