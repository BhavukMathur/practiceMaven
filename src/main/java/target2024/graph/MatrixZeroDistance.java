package target2024.graph;

//https://leetcode.com/problems/01-matrix/description/

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

class DistNode {
	int i;
	int j;
	int dist;

	public DistNode(int i, int j, int dist) {
		this.i = i;
		this.j = j;
		this.dist = dist;
	}
}

public class MatrixZeroDistance {
	public static void main(String[] args) {
		int[][] arr = {
				{0,1, 0},
				{0,1, 0},
				{0,1, 0},
				{0,1, 0},
				{0,1, 0}
		};

		int[][] result = updateMatrix(arr);

		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] updateMatrix(int[][] mat) {
		int[][] result = new int[mat.length][mat[0].length];
		Queue<DistNode> queue = new LinkedList<>();

		//BFS
		//Maintain a queue of node (i, j, dist) and add all 0s
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				if(mat[i][j] == 0) {
					queue.add(new DistNode(i, j, 0));
					result[i][j] = 0;
				} else {
					result[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		int i, j, dist;
		DistNode node;
		while(!queue.isEmpty()) {
			node = queue.poll();
			i = node.i;
			j = node.j;
			dist = node.dist;
			result[i][j] = dist;
			validateAndUpdateQueue(queue, mat, i-1, j, dist+1, result);
			validateAndUpdateQueue(queue, mat, i, j+1, dist+1, result);
			validateAndUpdateQueue(queue, mat, i+1, j, dist+1, result);
			validateAndUpdateQueue(queue, mat, i, j-1, dist+1, result);
		}

		return result;
	}

	private static void validateAndUpdateQueue(
			Queue<DistNode> queue, int[][] mat, int i, int j, int dist, int[][] result
	) {
		if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
			return;
		}
		if(mat[i][j] == 0) {
			return;
		}
		if(dist >= result[i][j]) {
			return;
		}
		if(result[i][j] == Integer.MAX_VALUE) {
			DistNode node = new DistNode(i, j, dist);
			queue.add(node);
		}
		result[i][j] = dist;
	}

}
