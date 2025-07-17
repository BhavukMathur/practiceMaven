package target2024.treeHeap;

//https://leetcode.com/problems/range-sum-of-bst/description/
public class RangeSumBST {
	int sum = 0;
	public static void main(String[] args) {
		RangeSumBST rsb = new RangeSumBST();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);
		int low = 7, high = 15;
		System.out.println(rsb.rangeSumBST(root, low, high));
	}

	public int rangeSumBST(TreeNode root, int low, int high) {
		rangeSumBSTDFS(root, low, high);
		return sum;
	}

	public void rangeSumBSTDFS(TreeNode root, int low, int high) {
		if(root == null) {
			return;
		}
		//If root is less than low, traverse right only
		if(root.val < low) {
			rangeSumBSTDFS(root.right, low, high);
			return;
		}

		//If root is higher than high, traverse left
		if(root.val > high) {
			rangeSumBSTDFS(root.left, low, high);
			return;
		}

		//If root is between low and high --> traverse both direction and add root
		sum = sum + root.val;
		rangeSumBSTDFS(root.right, low, high);
		rangeSumBSTDFS(root.left, low, high);
	}

}
