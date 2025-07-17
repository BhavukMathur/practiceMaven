package target2024.treeHeap;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
class LevelNode {
	TreeNode treeNode;
	int level;

	public LevelNode(TreeNode treeNode, int level) {
		this.treeNode = treeNode;
		this.level = level;
	}
}

public class LevelView {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.left.right = new TreeNode(16);
		root.right.right = new TreeNode(7);
//		List<List<Integer>> result = levelOrder(root);
		List<List<Integer>> result = levelOrderOpt(root);

		result.forEach(level -> {
			level.forEach(node -> {
				System.out.print(node + " ");
			});
			System.out.println();
		});
	}

	public static List<List<Integer>> levelOrderOpt(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		Map<Integer, List<Integer>> map = new LinkedHashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int size, ind=0;
		List<Integer> list;
		while(!queue.isEmpty()) {
			size = queue.size();
			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
//				System.out.print(node.val + " --" );
				if(map.get(ind) == null) {
					list = new LinkedList<>();
				} else {
					list = map.get(ind);
				}

				list.add(node.val);
				map.put(ind, list);

				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
			ind++;
//			System.out.println();
		}

		for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {

		int depth = depth(root, 0, 0);

		//If not depth, check for the size of queue in a loop at each step.

		System.out.println("Depth of the tree = " + depth);

		//Or use linkedHashMap
		List<List<Integer>> result = new LinkedList<>();

		for(int i=0; i<depth+1; i++) {
			result.add(new LinkedList<>());
		}

		Queue<LevelNode> queue = new LinkedList<>();
		if(root == null) {
			return result;
		}
		LevelNode levelNode = new LevelNode(root, 0);
		queue.add(levelNode);
		int ind;
		List<Integer> list;
		while(!queue.isEmpty()) {
			levelNode = queue.poll();
			ind = levelNode.level;
			if(result.get(ind) == null) {
				list = new LinkedList<>();
				list.add(levelNode.treeNode.val);
				result.add(ind, list);
			} else {
				list = result.get(ind);
				list.add(levelNode.treeNode.val);
			}
			if(levelNode.treeNode.left != null) {
				queue.add(new LevelNode(levelNode.treeNode.left, levelNode.level + 1));
			}
			if(levelNode.treeNode.right != null) {
				queue.add(new LevelNode(levelNode.treeNode.right, levelNode.level + 1));
			}
		}
		return result;
	}

	public static Integer depth(TreeNode root, int maxDepth, int depthSoFar) {
		if(root == null) {
			return maxDepth;
		}
		if(depthSoFar > maxDepth) {
			maxDepth = depthSoFar;
		}

		int left = depth(root.left, maxDepth, depthSoFar + 1);
		int right = depth(root.right, maxDepth, depthSoFar + 1);

		maxDepth = Integer.max(maxDepth, left);
		maxDepth = Integer.max(maxDepth, right);
		return maxDepth;
	}
}
