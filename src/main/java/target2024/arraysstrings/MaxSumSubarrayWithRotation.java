package target2024.arraysstrings;

public class MaxSumSubarrayWithRotation {

    public static int maxSumSubarrayWithRotation(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        // Create doubled array
        int[] extended = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            extended[i] = arr[i % n];
        }

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int start = 0;

        for (int end = 0; end < 2 * n; end++) {
            currSum += extended[end];

            // If window exceeds size n, shrink it
            if (end - start + 1 > n) {
                currSum -= extended[start];
                start++;
            }

            // Only consider full-sized windows
            if (end - start + 1 == n) {
                maxSum = Math.max(maxSum, kadaneWithinWindow(extended, start, end));
            }
        }

        return maxSum;
    }

    // Kadane’s applied on subarray [start..end]
    private static int kadaneWithinWindow(int[] arr, int start, int end) {
        int maxEndingHere = arr[start];
        int maxSoFar = arr[start];

        for (int i = start + 1; i <= end; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 4};
        System.out.println(maxSumSubarrayWithRotation(arr));  // Output: 5
    }
}
