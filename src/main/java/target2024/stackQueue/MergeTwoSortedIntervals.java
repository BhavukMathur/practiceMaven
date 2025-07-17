package target2024.stackQueue;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Deque;
import java.util.LinkedList;

@AllArgsConstructor
@Setter
class Interval {
	int start;
	int end;
}

//[4,6], j[8,10], [11,12]

public class MergeTwoSortedIntervals {
	public static void main(String[] args) {
		Interval[] intervalA = {new Interval(1, 2), new Interval(3, 9)};
		Interval[] intervalB = {new Interval(4, 6), new Interval(8, 10), new Interval(11, 12)};
		//{[1,2], [3,10], [11,12]}

		Deque<Interval> result = mergeInterval(intervalA, intervalB);
		result.forEach(interval -> {
			System.out.println(interval.start + " : " + interval.end);
		});
	}

	//TODO: Fix the code
	private static Deque<Interval> mergeInterval(Interval[] a, Interval[] b) {
		Deque<Interval> result = new LinkedList<>();

		int i=0, j=0;

		//Iterate both the lists
		Interval ia, ib, merge;

		while(i < a.length && j < b.length) {
			ia = a[i];
			ib = b[j];

			if(hasOverlap(ia, ib)) {
				merge = new Interval(Integer.min(ia.start, ib.start), Integer.max(ia.end, ib.end));
				updateDeque(result, merge);
				i++;
				j++;
			} else {
				if(ia.start < ib.start) {
					updateDeque(result, ia);
					i++;
				} else {
					updateDeque(result, ib);
					j++;
				}
			}
		}

		//List A iterated
		if(i < a.length) {
			while(j >= 0) {
				updateDeque(result, b[j]);
				j--;
			}
		} else {
			//List B iterated
			while(i >= 0) {
				updateDeque(result, a[j]);
				i--;
			}
		}
		return result;
	}

	private static void updateDeque(Deque<Interval> result, Interval interval) {
		Interval peekLast, merge;
		if(result.isEmpty()) {
			result.add(interval);
		} else {
			peekLast = result.peekLast();
			if(hasOverlap(peekLast, interval)) {
				Interval temp = result.pollLast();
				merge = new Interval(Integer.min(temp.start, interval.start), Integer.max(temp.end, interval.end));
				result.add(merge);
			} else {
				result.add(interval);
			}
		}
	}

//	(2, 4)
//	(1, 3)
private static boolean hasOverlap(Interval a, Interval b) {
	if (a.end >= b.start && b.end >= a.start) {
		return true;
	}
	return false;
}}
