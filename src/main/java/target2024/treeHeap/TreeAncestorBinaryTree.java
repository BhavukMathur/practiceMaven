package target2024.treeHeap;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class TreeAncestorBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		//6, 4 --> 5
		System.out.println(lowestCommonAncestor(root, root.left.left, root.left.right.right).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) {
			return null;
		}
		if(root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if(left != null && right != null) {
			return root;
		}

		return (left != null ? left : right);
	}
}
