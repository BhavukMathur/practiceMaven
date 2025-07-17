package target2024.treeHeap;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 *	 			10
 * 			5		15
 * 		3		7		18
 * 	1
 */
public class RightView {
	public static void main(String[] args) {
		RightView views = new RightView();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);

//		views.rightSideViewDFS(root);
		List<Integer> result = views.rightSideViewBFS(root);
		System.out.println(result);
	}

	public List<Integer> rightSideViewBFS(TreeNode root) {
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
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
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

	public List<Integer> rightSideViewDFS(TreeNode root) {
		Map<Integer, Integer> viewMap = new TreeMap<>();
		rightSideViewRec(root, viewMap, 0);

		List<Integer> result = new LinkedList<>();
		for(Map.Entry<Integer, Integer> entry: viewMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			result.add(entry.getValue());
		}
		return result;
	}


	public void rightSideViewRec(TreeNode root, Map<Integer, Integer> viewMap, int ind) {
		if(root == null) {
			return;
		}
		rightSideViewRec(root.right, viewMap, ind+1);
		if(viewMap.containsKey(ind)) {
			//Do nothing
		} else {
			viewMap.put(ind, root.val);
		}
		rightSideViewRec(root.left, viewMap, ind+1);
	}

}
