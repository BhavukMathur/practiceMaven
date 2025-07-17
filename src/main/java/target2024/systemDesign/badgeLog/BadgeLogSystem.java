package target2024.systemDesign.badgeLog;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * class BadgeLog: List<Integer> checkin, List<Integer> checkout
 * Methods: checkIn(), checkOut()
 *
 * class BadgeLogManager: Map<String, BadgeLog> employeeBadgeLog
 * Methods: addEmployee(), checkIn(), checkOut()
 */

class BadgeLog {
	List<Integer> checkIn;
	List<Integer> checkOut;

	BadgeLog() {
		checkIn = new LinkedList<>();
		checkOut = new LinkedList<>();
	}

	void checkIn(int time) {
		checkIn.add(time);
	}
	void checkOut(int time) {
		checkOut.add(time);
	}

	Integer getTotalTime() {
		int totalTime = 0;
		for(int i=0; i<checkIn.size(); i++) {
			totalTime = totalTime + (checkOut.get(i) - checkIn.get(i));
		}
		return totalTime;
	}
}

class BadgeLogManager {
	Map<String, BadgeLog> employeeBadge;
	BadgeLogManager() {
		employeeBadge = new HashMap<>();
	}

	void addEmployee(String employeeId) {
		employeeBadge.put(employeeId, new BadgeLog());
	}

	void checkIn(String employeeId, Integer time) throws Exception {
		BadgeLog badgeLog = employeeBadge.get(employeeId);
		if(badgeLog != null) {
			badgeLog.checkIn(time);
		} else {
			throw new Exception("EmployeeId not found");
		}
	}

	void checkOut(String employeeId, Integer time) throws Exception {
		BadgeLog badgeLog = employeeBadge.get(employeeId);
		if(badgeLog != null) {
			badgeLog.checkOut(time);
		} else {
			throw new Exception("EmployeeId not found");
		}
	}

	Map<String, Integer> getEmployeeTime() {
		Map<String, Integer> employeeTime = new HashMap<>();

		employeeBadge.forEach((employeeId, badge) -> {
			int totalTime = badge.getTotalTime();
			employeeTime.put(employeeId, totalTime);
		});
		return employeeTime;
	}
}

public class BadgeLogSystem {
	public static void main(String[] args) {
		BadgeLogManager bm = new BadgeLogManager();
		bm.addEmployee("11");
		bm.addEmployee("22");

		try {
			bm.checkIn("11", 8);
			bm.checkIn("22", 11);
			bm.checkOut("11", 12);
			bm.checkOut("22", 12);
			bm.checkIn("11", 13);
			bm.checkIn("22", 13);
			bm.checkOut("11", 16);
			bm.checkOut("22", 17);

			System.out.println("Total office hours for the employees");
			System.out.println(bm.getEmployeeTime());
		} catch (Exception ex) {
			System.out.println("Exception = " + ex.getMessage());
		}
	}
}
