package target2024.algorithms;

public class BusStations {
	public static void main(String[] args) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800, 11000, 15000, 18000, 19000, 20000, 21000};
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

		//Max stations required
		int i=0;
		int j=0;
		int maxStations = 0;
		int finalMax = maxStations;

		while(i<arr.length && j<dep.length) {
			if(arr[i] <= dep[j]) {
				maxStations++;
				i++;
			}
			else if(arr[i] > dep[j]) {
				maxStations--;
				j++;
			}
			finalMax = maxStations > finalMax ? maxStations : finalMax;
		}

		while(i < arr.length) {
			maxStations++;
			i++;
			finalMax = maxStations > finalMax ? maxStations : finalMax;
		}

		System.out.println("Max stations required=" + finalMax);
	}
}
