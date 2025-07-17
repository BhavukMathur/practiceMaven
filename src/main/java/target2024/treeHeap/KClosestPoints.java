package target2024.treeHeap;

//https://leetcode.com/problems/k-closest-points-to-origin/description/

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Point implements Comparable<Point> {
	int x, y;
	int distance;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.distance = x*x + y*y;
	}

	@Override
	public int compareTo(Point o) {
		return Integer.compare(this.distance, o.distance);
	}
}

public class KClosestPoints {
	public static void main(String[] args) {
		int[][] arr = {{3,3},{5,-1},{-2,4}};
		int k=2;
		int[][] result = kClosest(arr, k);
		for(int i=0; i<k; i++) {
			System.out.println(result[i][0] + " " + result[i][1]);
		}
	}

	public static int[][] kClosest(int[][] arr, int k) {
		List<Point> pointList = new LinkedList<>();
		PriorityQueue<Point> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for(int i=0; i<arr.length; i++) {
			Point temp = new Point(arr[i][0], arr[i][1]);
			pointList.add(temp);
			if(maxHeap.size() < k) {
				maxHeap.add(temp);
			} else {
				if(maxHeap.peek().distance > temp.distance) {
					maxHeap.poll();
					maxHeap.add(temp);
				} else {
					//Ignore
				}
			}
		}

		int[][] result = new int[k][2];
		Point point;
		int i=0;
		while(!maxHeap.isEmpty()) {
			point = maxHeap.poll();
			result[i][0] = point.x;
			result[i][1] = point.y;
			i++;
		}
		return result;
	}
}
