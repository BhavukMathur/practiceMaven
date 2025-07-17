package target2024.algorithms;

import java.util.Arrays;

public class RainWaterCollection {
	public static void main(String[] args) {
		RainWaterCollection rw = new RainWaterCollection();
		int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println("Water collected = " + rw.trap(arr));
	}

	public int trap(int[] arr) {
		int size = arr.length;

		int[] maxHeightLeft = new int[size];
		int[] maxHeightRight = new int[size];

		maxHeightLeft[0] = 0;
		maxHeightRight[size-1] = 0;
		int maxSoFar = 0;

		for(int i=1; i<size; i++) {
			maxHeightLeft[i] = Math.max(maxSoFar, arr[i-1]);
			maxSoFar = maxHeightLeft[i];
		}

		maxSoFar = 0;
		for(int i= size-2; i>=0; i--) {
			maxHeightRight[i] = Math.max(maxSoFar, arr[i+1]);
			maxSoFar = maxHeightRight[i];
		}

		int water = 0;
		int tmp;
		for(int i=0; i<size; i++) {
			tmp = Math.min(maxHeightLeft[i], maxHeightRight[i]);
			if((tmp - arr[i]) > 0) {
				water = water + tmp - arr[i];
			}
		}
		System.out.println(Arrays.toString(maxHeightLeft));
		System.out.println(Arrays.toString(maxHeightRight));
		return water;
	}

}
