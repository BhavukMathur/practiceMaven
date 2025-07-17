package target2024.treeHeap;

public class SortedListToBalancedBST {
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
		TreeNode root = null;
		root = insertBalancedBST(arr, 0, arr.length-1);
		TreeMain.printTree(root);
	}

	private static TreeNode insertBalancedBST(int[] arr, int left, int right) {
		if(left > right || left < 0 || right > arr.length) {
			return null;
		}

		if (left == right) {
			return new TreeNode(arr[left]);
		}

		int mid = (left + right) / 2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = insertBalancedBST(arr, left, mid-1);
		node.right = insertBalancedBST(arr, mid+1, right);
		return node;
	}
}
