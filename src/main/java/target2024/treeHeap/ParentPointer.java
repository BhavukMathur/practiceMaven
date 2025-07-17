package target2024.treeHeap;

import java.util.LinkedList;
import java.util.List;

/**
 * # Example
 * #       A
 * #     /   \
 * #    B     C
 * #   / \   / \
 * #  D   E F   G
 * # /         /
 * # H        I
 *
 * Find common ancestor
 */

class ParentTreeNode {
	ParentTreeNode left;
	ParentTreeNode right;
	ParentTreeNode parent;
	Character val;

	ParentTreeNode(char ch) {
		this.val = ch;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}

public class ParentPointer {
	public static void main(String[] args) {
		ParentTreeNode root = new ParentTreeNode('A');
		root.left = new ParentTreeNode('B'); root.left.parent = root;
		root.right = new ParentTreeNode('C'); root.right.parent = root;
		root.left.left = new ParentTreeNode('D'); root.left.left.parent = root.left;
		root.left.left.left = new ParentTreeNode('H'); root.left.left.left.parent = root.left.left;
		root.left.right = new ParentTreeNode('E'); root.left.right.parent = root.left;

		ParentTreeNode ancestor = findParent(root.left.left.left, root.left.right);
		System.out.println(ancestor.val);
	}

	private static ParentTreeNode findParent(ParentTreeNode a, ParentTreeNode b) {
		List<ParentTreeNode> listA = new LinkedList<>();
		List<ParentTreeNode> listB = new LinkedList<>();

		ParentTreeNode trvA = a, trvB = b;
		while(trvA != null) {
			listA.add(trvA);
			trvA = trvA.parent;
		}
		while(trvB != null) {
			listB.add(trvB);
			trvB = trvB.parent;
		}

		int i, j;
		for(i=listA.size()-1, j=listB.size()-1; i>=0 && j>=0;) {
			if(listA.get(i).val == listB.get(j).val) {
				i--;
				j--;
			}
			else {
				i++;
				return listA.get(i);
			}
		}

		i++;
		return listA.get(i);
	}
}
