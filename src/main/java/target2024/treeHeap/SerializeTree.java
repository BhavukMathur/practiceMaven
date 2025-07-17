package target2024.treeHeap;

import com.sun.source.tree.Tree;

import java.util.Arrays;

public class SerializeTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.left.right = new TreeNode(6);
		Integer[] result = serialize(root);

		System.out.println(Arrays.toString(result));
	}

	public static Integer[] serialize(TreeNode root) {
		Integer[] result = new Integer[15]; //2^n - 1 (starting from 1)
		serializeRec(root, result, 0);
		return result;
	}

	public static void serializeRec(TreeNode root, Integer[] result, int ind) {
		if(ind > result.length) {
			return;
		}
		if(root == null) {
			result[ind] = null;
			return;
		}

		result[ind] = root.val;
		serializeRec(root.left, result, 2*ind + 1);
		serializeRec(root.right, result, 2*ind + 2);
	}
}
