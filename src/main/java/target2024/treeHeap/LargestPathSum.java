package target2024.treeHeap;

import com.sun.source.tree.Tree;

/**
 * 		-15
 * 	-10		   20
 * 		   -15     -5
 *       5     20
 */

public class LargestPathSum {

	final static int MIN_VALUE = -9999;
	static int maxSoFar = MIN_VALUE;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-15);
		root.left = new TreeNode(-10);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(-15);
		root.right.right = new TreeNode(-5);
		root.right.left.left = new TreeNode(5);
		root.right.left.right = new TreeNode(20);

		maxSoFar = root.val;
		largestPathSum(root);

		System.out.println(maxSoFar);
	}

	public static int largestPathSum(TreeNode root) {
		int leftSum = MIN_VALUE, rightSum = MIN_VALUE;

		if(root.left != null) {
			leftSum = largestPathSum(root.left);
		}
		if(root.right != null) {
			rightSum = largestPathSum(root.right);
		}

		//maxOf(root, left+root, right+root, left+root+right, maxSoFar)
		maxSoFar = Integer.max(maxSoFar, root.val);
		maxSoFar = Integer.max(maxSoFar, leftSum + root.val);
		maxSoFar = Integer.max(maxSoFar, rightSum + root.val);
		maxSoFar = Integer.max(maxSoFar, leftSum + rightSum + root.val);

		int maxIfRootIncluded = root.val;
		maxIfRootIncluded = Integer.max(maxIfRootIncluded, root.val);
		maxIfRootIncluded = Integer.max(maxIfRootIncluded, leftSum + root.val);
		maxIfRootIncluded = Integer.max(maxIfRootIncluded, rightSum + root.val);

		return maxIfRootIncluded;

	}
}
