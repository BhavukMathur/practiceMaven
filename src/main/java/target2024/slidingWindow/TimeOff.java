package target2024.slidingWindow;

//If the result needs to be continuous
public class TimeOff {
	public static void main(String[] args) {
		char[] calendar = {'W', 'W', 'H', 'W', 'W', 'H', 'W'};
		int pto = 2;
		int result = findMaxHolidays(calendar, pto);
		System.out.println(result);
	}

	private static Integer findMaxHolidays(char[] calendar, int pto) {
		int maxWindow = Integer.MIN_VALUE;
		int i=0, j=0;
		int holidaysSoFar = 0;

		for(i=0, j=0; i<calendar.length && j<calendar.length;) {
			if(calendar[j] == 'W') {
				if(holidaysSoFar < pto) {
					holidaysSoFar++;
					maxWindow = Integer.max(maxWindow, (j - i)+1);
					j++;
				} else {
					i++;
					holidaysSoFar--;
				}
			} else {
				maxWindow = Integer.max(maxWindow, (j - i)+1);
				j++;
			}
		}
		return maxWindow;
	}
}
