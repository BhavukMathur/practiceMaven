package target2024.treeHeap;

public class SplitBST {
	public static void main(String[] args) {
		SplitBST sbst = new SplitBST();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);

		TreeNode[] result = sbst.splitBST(root, 2);
		System.out.println(result[0].val + " : " + result[1].val);
	}

	public TreeNode[] splitBST(TreeNode root, int target) {
		if(root == null) {
			return new TreeNode[] {null, null};
		}

		TreeNode[] result;

		if (root.val <= target) {
			result = splitBST(root.right, target);
			root.right = result[0];
			result[0] = root;
		} else {
			result = splitBST(root.left, target);
			root.left = result[1];
			result[1] = root;
		}

		return result;
	}

}
