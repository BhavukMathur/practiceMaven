package target2024.treeHeap;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalTreeTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.right = new TreeNode(1);
//		root.left.left = new TreeNode(1);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<List<Integer>> result = verticalTraversal(root);

		result.forEach(level -> {
			level.forEach(node -> {
				System.out.print(node + " ");
			});
			System.out.println();
		});

	}

	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		int ldist = findLeftDist(root, Integer.MAX_VALUE, 0);
		int rdist = findRightDist(root, Integer.MIN_VALUE, 0);
//		System.out.println(ldist + " -- " + rdist);
		int width = rdist - ldist + 1;
		List<List<Integer>> result = new ArrayList<>();
		TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
		for(int i=ldist; i<=rdist; i++) {
			treeMap.put(i, new ArrayList<>());
		}
		verticalTraversalRec(root, treeMap, 0);

		for(int i=ldist; i<=rdist; i++) {
			List<Integer> list = treeMap.get(i);
			Collections.sort(list);
			result.add(list);
		}
		return result;
	}

	public static void verticalTraversalRec(TreeNode root, TreeMap<Integer, List<Integer>> treeMap, int ind) {
		if(root == null) {
			return;
		}
//		System.out.println(root.val + " -- " + ind);
		List<Integer> arrayList = treeMap.get(ind);
		arrayList.add(root.val);
		treeMap.put(ind, arrayList);
		verticalTraversalRec(root.left, treeMap, ind-1);
		verticalTraversalRec(root.right, treeMap, ind+1);
	}

	private static int findLeftDist(TreeNode root, int minSoFar, int ind) {
		if(root == null) {
			return minSoFar;
		}
		if(ind < minSoFar) {
			minSoFar = ind;
		}
		int left = findLeftDist(root.left, minSoFar, ind-1);
		int right = findLeftDist(root.right, minSoFar, ind+1);

		minSoFar = Integer.min(minSoFar, left);
		minSoFar = Integer.min(minSoFar, right);
		return minSoFar;
	}

	private static int findRightDist(TreeNode root, int maxSoFar, int ind) {
		if(root == null) {
			return maxSoFar;
		}
		if(ind > maxSoFar) {
			maxSoFar = ind;
		}
		int left = findRightDist(root.left, maxSoFar, ind-1);
		int right = findRightDist(root.right, maxSoFar, ind+1);

		maxSoFar = Integer.max(maxSoFar, left);
		maxSoFar = Integer.max(maxSoFar, right);
		return maxSoFar;
	}
}
