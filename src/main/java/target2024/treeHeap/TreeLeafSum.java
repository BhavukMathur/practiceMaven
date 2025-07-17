package target2024.treeHeap;

import java.util.Stack;

public class TreeLeafSum {
	public static void main(String[] args) {
		Integer[] root = {5,4,8,11,null,13,4,7,2,null,null,null,null,null,1};
		Stack<Integer> pathList = new Stack<>();
		int targetSum = 18;

		System.out.println(isTargetSumFound(root, targetSum, 0, 0, pathList));
	}

	private static boolean isTargetSumFound(Integer[] root, int targetSum, int sumSoFar, int ind, Stack<Integer> pathList) {
		if(ind >= root.length) {
			return false;
		}
		if(root[ind] == null) {
			return false;
		}
		sumSoFar = sumSoFar + root[ind];
		pathList.add(root[ind]);
		if(sumSoFar > targetSum) {
			pathList.pop();
			return false;
		}

		int leftInd = 2*ind + 1;
		int rightInd = 2*ind + 2;

		if((sumSoFar == targetSum) && (isLeafInd(root, leftInd)) && (isLeafInd(root, rightInd))) {
			System.out.println(pathList);
			return true;
		}

		if(isTargetSumFound(root, targetSum, sumSoFar, leftInd, pathList)
				|| isTargetSumFound(root, targetSum, sumSoFar, rightInd, pathList)) {
			return true;
		} else {
			pathList.pop();
			return false;
		}

	}

	private static boolean isLeafInd(Integer[] root, int ind) {
		if(ind >= root.length || root[ind] == null) {
			return true;
		}
		return false;
	}
}
