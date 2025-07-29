package target2024.treeHeap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
/**
 *         3
         /   \
        5     1
       / \   / \
      6   2 0   8
         / \
        7   4
 */

public class TreeAncestorBinaryTreeMultiple {
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
		System.out.println(lowestCommonAncestor(root, 
				Arrays.asList(root.left.left, root.left.right.left, root.left.right.right)).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		
		Set<TreeNode> nodeSet = new HashSet<>(nodes);
		return findLCA(root, nodeSet);
	}
	
	public static TreeNode findLCA(TreeNode root, Set<TreeNode> nodeSet) {
		if(root == null) {
			return root;
		}
		
		if(nodeSet.contains(root)) {
			return root;
		}
		
		TreeNode left = findLCA(root.left, nodeSet);
		TreeNode right = findLCA(root.right, nodeSet);
		
		if(left != null && right != null) {
			return root;
		}
		
		return (left != null ? left : right);
	}
}
