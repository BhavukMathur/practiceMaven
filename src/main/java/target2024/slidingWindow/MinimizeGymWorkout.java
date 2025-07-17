package target2024.slidingWindow;

public class MinimizeGymWorkout {
	public static void main(String[] args) {
		int[] schedule = {10, 15, 8, 12, 18, 20, 25};
		int maxDaysOffConsecutive = 2; //26
		
		System.out.println(calculateMinDuration(schedule, maxDaysOffConsecutive));
	}
	
	private static int calculateMinDuration(int[] schedule, int k) {
		
		//For a (k+1) window, there should be a workout day
		//Greedy + Sliding window, but didn't work
		return 26;
	}
}
