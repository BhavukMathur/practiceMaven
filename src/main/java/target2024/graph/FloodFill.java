package target2024.graph;

public class FloodFill {
	public static void main(String[] args) {
		int arr[][] =   {{1, 1, 1, 1, 0, 1},
						{1, 0, 0, 1, 1, 0},
						{0, 1, 1, 1, 1, 0},
						{1, 1, 0, 0, 0, 1},
						{1, 1, 1, 1, 0, 1},
						{1, 0, 1, 1, 0, 1}};

		int rowSize = arr.length;
		int colSize = arr[0].length;
		int row=3, col=4;
		int visited[][] = new int[rowSize][colSize];

		for(int i=0; i< rowSize; i++) {
			for(int j=0; j<colSize; j++) {
				visited[i][j] = 0;
			}
		}

		System.out.println("Initial array");
		for(int i=0; i< rowSize; i++) {
			for(int j=0; j<colSize; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		floodFill(arr, visited, row, col);

		System.out.println("Final array");
		for(int i=0; i< rowSize; i++) {
			for(int j=0; j<colSize; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void floodFill(int arr[][], int visited[][], int row, int col) {
		if (row >= arr.length) return;
		if (col >= arr[0].length) return;
		if (row < 0) return;
		if (col < 0) return;
		if (visited[row][col] == 1) return;
		if (arr[row][col] == 1) return;

		visited[row][col] = 1;
		arr[row][col] = 1;
		floodFill(arr, visited, row, col-1);
		floodFill(arr, visited, row, col+1);
		floodFill(arr, visited, row-1, col);
		floodFill(arr, visited, row+1, col);
	}
}
