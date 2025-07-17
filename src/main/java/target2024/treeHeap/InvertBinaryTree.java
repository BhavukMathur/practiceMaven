package target2024.treeHeap;

public class InvertBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root = invertTree(root);
		System.out.println(root.left.left.val);
	}

	public static TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}

		TreeNode temp = invertTree(root.left);
		root.left = invertTree(root.right);
		root.right = temp;
		return root;
	}
}
