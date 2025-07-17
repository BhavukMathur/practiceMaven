package target2024.treeHeap;

/**
 *    2
 *  3  4
 * 1 5
 * 231 + 235 + 24
 */

public class RootToLeafSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(5);

		RootToLeafSum rl = new RootToLeafSum();
		System.out.println(rl.rootToLeafSum(root, 0));
	}

	public int rootToLeafSum(TreeNode root, int val) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return val + root.val;
		}

		int sumSoFar = val + root.val;
		int leftSum = rootToLeafSum(root.left, 10*sumSoFar);
		int rightSum = rootToLeafSum(root.right, 10*sumSoFar);

		return leftSum + rightSum;
	}
}
