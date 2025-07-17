package target2024.arraysstrings;

import java.util.Arrays;

//https://www.metacareers.com/profile/coding_practice_question/?problem_id=192049171861831&c=1373057600385980&psid=275492097255885&practice_plan=0&b=0111122
public class RevenueMilestones {
	public static void main(String[] args) {
		RevenueMilestones rm = new RevenueMilestones();
//		int[] revenues = {100, 200, 300, 400, 500};
//		int[] milestones= {300, 800, 1000, 1400};
//		System.out.println(Arrays.toString(rm.getMilestoneDaysSorted(revenues, milestones)));

		int[] revenues = {700, 800, 600, 400, 600, 700};
		int[] milestones= {3100, 2200, 800, 2100, 1000};
		//Output = {5, 4, 2, 3, 2}
		System.out.println(Arrays.toString(rm.getMilestoneDays(revenues, milestones)));

	}

	int[] getMilestoneDays(int[] revenues, int[] milestones) {
		int[] cumulative = new int[revenues.length];
		cumulative[0] = revenues[0];
		for(int i=1; i<revenues.length; i++) {
			cumulative[i] = cumulative[i-1] + revenues[i];
		}

		int[] milestoneDays = new int[milestones.length];
		for(int i=0; i<milestones.length; i++) {
			milestoneDays[i] = binarySearch(cumulative, milestones[i], 0, cumulative.length - 1);
		}
		return milestoneDays;
	}

	private int binarySearch(int[] cumulative, int revenue, int left, int right) {
		if(left < 0 || right >= cumulative.length || left > right) {
			return -1;
		}
		if((left == right) && cumulative[left] < revenue) {
			return -1;
		} else if ((left == right) && cumulative[left] >= revenue) {
			return left+1;
		}

		int mid = (left + right) / 2;
		if(cumulative[mid] == revenue) {
			return mid+1;
		}
		if(cumulative[mid] < revenue) {
			//Go to right
			return binarySearch(cumulative, revenue, mid+1, right);
		} else {
			//Go to left
			return binarySearch(cumulative, revenue, left, mid);
		}
	}


	int[] getMilestoneDaysSorted(int[] revenues, int[] milestones) {
		System.out.println(Arrays.toString(revenues));
		System.out.println(Arrays.toString(milestones));
		int[] output = new int[milestones.length];

		int j=0;
		int sum = 0;
		for(int i=0; i<revenues.length; i++) {
			sum = sum + revenues[i];
			while(j<milestones.length && sum >= milestones[j]) {
				output[j] = i+1;
				j++;
			}
		}
		return output;
	}
}
