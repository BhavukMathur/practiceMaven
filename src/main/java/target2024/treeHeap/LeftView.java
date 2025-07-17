package target2024.treeHeap;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *	 			10
 * 			5		15
 * 		3		7		18
 * 	1
 */


public class LeftView {
	public static void main(String[] args) {
		LeftView leftView = new LeftView();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);

		List<Integer> result = leftView.leftSideViewBFS(root);
		System.out.println(result);
	}

	public List<Integer> leftSideViewBFS(TreeNode root) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int ind = 0, size;
		TreeNode node;
		while(!queue.isEmpty()) {
			size = queue.size();
			for(int i=0; i<size; i++) {
				node = queue.poll();
				map.put(ind, node.val);
				if(node.right != null) {
					queue.add(node.right);
				}
				if(node.left != null) {
					queue.add(node.left);
				}
			}
			ind++;
		}

		List<Integer> result = new LinkedList<>();
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}
}
