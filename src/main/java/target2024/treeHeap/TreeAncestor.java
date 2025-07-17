package target2024.treeHeap;

public class TreeAncestor {
	public static void main(String[] args) {
		int[] arr = {10, 2, 15, 1, 5, 12, 20, 4};
		TreeNode root = null;

		for(int i=0; i<arr.length; i++) {
			root = TreeMain.insertBST(root, arr[i]);
		}

		int a=4, b=20;

		//First validate in hashset
		int commonAncestor = findCommonAncestor(root, a, b);
		System.out.println("Common Ancestor of " + a + " and " + b + " is = " + commonAncestor);
	}

	private static int findCommonAncestor(TreeNode root, int a, int b) {
		if(root == null)
			return -1;

		if(root.val <= a && root.val <= b) {
			//Right recursion
			return findCommonAncestor(root.right, a, b);
		}

		if(root.val > a && root.val > b) {
			//Left recursion
			return findCommonAncestor(root.left, a, b);
		}

		return root.val;
	}

}
