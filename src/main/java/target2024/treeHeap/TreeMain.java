package target2024.treeHeap;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	TreeNode left, right;
	int val;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class TreeMain {
	public static void main(String[] args) {
		int[] bstArr = {10, 2, 15, 1, 5, 12, 20};
		TreeNode root = null;
//		TreeNode levelRoot = null;

		System.out.println("\nBST Insertion");
		for(int i=0; i<bstArr.length; i++) {
			root = insertBST(root, bstArr[i]);
		}

//		System.out.println("\nLevel Insertion");
//		levelRoot = levelInsert(bstArr, 0);
		printTree(root);
		printLevelOrder(bstArr, root);

		System.out.println("\nPretty Level Traversal");
		List<List<Integer>> depthList = new ArrayList<>(bstArr.length);
		constructLevelOrderPretty(depthList, 0, root);
		printLevelOrderPretty(depthList);
	}

	public static void printLevelOrderPretty(List<List<Integer>> depthList) {
		for(int i=0; i<depthList.size(); i++) {
			List<Integer> innerList = depthList.get(i);
			System.out.print(i + " --> ");
			for(int j=0; j< innerList.size(); j++) {
				System.out.print(innerList.get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void constructLevelOrderPretty(List<List<Integer>> depthList, int ind, TreeNode root) {
		if(root == null)
			return;

		List<Integer> innerList;
		if(depthList.size() > ind) {
			innerList = depthList.get(ind);
			innerList.add(root.val);
		} else {
			innerList = new ArrayList<>();
			innerList.add(root.val);
			depthList.add(innerList);
		}

		constructLevelOrderPretty(depthList, ind+1, root.left);
		constructLevelOrderPretty(depthList, ind+1, root.right);
	}

	public static void printLevelOrder(int[] bstArr, TreeNode root) {
		System.out.println("\nLevel Traversal");
		int maxArrSize = (int) (Math.pow(2, bstArr.length) - 1);
		List<Integer> levelArr = new ArrayList(maxArrSize);

		for(int i=0; i<maxArrSize; i++) {
			levelArr.add(null);
		}

		constructLevelArray(root, levelArr, 0);
		System.out.println(maxArrSize);
		for(int i=0; i<maxArrSize; i++) {
			if(levelArr.get(i) != null) {
				System.out.print(levelArr.get(i) + " ");
			}
		}
		System.out.println();
	}

	public static void printTree(TreeNode root) {
		System.out.println("\nInOrder traversal");
		printInOrder(root);
		System.out.println("\nPreOrder traversal");
		printPreOrder(root);
		System.out.println("\nPostOrder traversal");
		printPostOrder(root);
	}

	private static void constructLevelArray(TreeNode levelRoot, List<Integer> levelArr, int ind) {
		if(levelRoot == null) {
			return;
		}
		if(ind >= levelArr.size()) {
			return;
		}
		levelArr.add(ind, levelRoot.val);
		constructLevelArray(levelRoot.left, levelArr, 2*ind + 1);
		constructLevelArray(levelRoot.right, levelArr, 2*ind + 2);
	}

	private static TreeNode levelInsert(int[] bstArr, int ind) {
		if(ind >= bstArr.length) {
			return null;
		}

		TreeNode root = new TreeNode(bstArr[ind]);
		root.left = levelInsert(bstArr, 2*ind + 1);
		root.right = levelInsert(bstArr, 2*ind + 2);
		return root;
	}

	private static void printInOrder(TreeNode root) {
		//l o r
		if(root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.print(root.val + " ");
		printInOrder(root.right);
	}

	private static void printPreOrder(TreeNode root) {
		//o l r
		if(root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	private static void printPostOrder(TreeNode root) {
		//l r o
		if(root == null) {
			return;
		}
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.val + " ");
	}

	public static TreeNode insertBST(TreeNode root, int val) {
		TreeNode temp = new TreeNode(val);
		if(root == null) {
			root = temp;
		} else if(root.val > val) {
			root.left = insertBST(root.left, val);
		} else if(root.val < val) {
			root.right = insertBST(root.right, val);
		}
		return root;
	}
}
