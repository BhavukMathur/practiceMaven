package target2024.arraysstrings;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150
public class SpiralMatrix {
	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//		int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		System.out.println(sm.spiralOrder(matrix));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> slist = new ArrayList<>();
		int up = 0, down = matrix.length, left = 0, right = matrix[0].length;
//		System.out.println(down + " " + right);
		int i=0, j=0;

		while(i>=up && i<down && j>=left && j<right) {
			//left --> right
			if(j>=right)
				break;
			while(j<right) {
				slist.add(matrix[i][j]);
				j++;
			}
			up++;
			j--;
			i++;

			//up --> down
			if(i>=down)
				break;
			while(i<down) {
				slist.add(matrix[i][j]);
				i++;
			}
			right--;
			i--;
			j--;

			//right --> left
			if(j<left)
				break;
			while(j>=left) {
				slist.add(matrix[i][j]);
				j--;
			}
			down--;
			j++;
			i--;

			//down --> up
			if(i<up)
				break;
			while(i >= up) {
				slist.add(matrix[i][j]);
				i--;
			}
			left++;
			i++;
			j++;
		}
		return slist;
	}
}
