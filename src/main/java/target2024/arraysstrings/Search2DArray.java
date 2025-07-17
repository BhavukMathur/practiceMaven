package target2024.arraysstrings;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Search2DArray {
	public static void main(String args[]) {
		int[][] arr = { { 10, 20, 30, 40 },
				{ 15, 25, 35, 45 },
				{ 27, 29, 37, 48 },
				{ 32, 33, 39, 50 } };

		//Other version if the array is completely sorted. Start from bottom left corner

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to be searched");
		int num = sc.nextInt();
		int rowLen = arr.length;
		int colLen = arr[0].length;
		find2DArray(arr, num, rowLen, colLen, 0, colLen-1);

	}

	private static void find2DArray(int[][] arr, int num, int rowLen, int colLen, int row, int col) {
		if(row >= rowLen || col >= colLen) {
			return;
		}

		if(num == arr[row][col]) {
			System.out.println("Found at Index - " + row + ", " + col);
			return;
		}

		if(num > arr[row][col]) {
			find2DArray(arr, num, rowLen, colLen, row+1, col);
		}
		else {
			find2DArray(arr, num, rowLen, colLen, row, col-1);
		}
	}
}
