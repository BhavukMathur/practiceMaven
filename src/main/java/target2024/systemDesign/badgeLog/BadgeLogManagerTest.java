package target2024.systemDesign.badgeLog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BadgeLogManagerTest {
	BadgeLogManager bm;

	@BeforeEach
	void setup() {
		BadgeLogManager bm = new BadgeLogManager();
	}

	@Test
	void addEmployee() {
	}

	@Test
	void checkIn() {
	}

	@Test
	void checkOut() {
	}

	@Test
	void getEmployeeTime() throws Exception {
		bm.addEmployee("11");
		bm.addEmployee("22");

		bm.checkIn("11", 8);
		bm.checkIn("22", 11);
		bm.checkOut("11", 12);
		bm.checkOut("22", 12);
		bm.checkIn("11", 13);
		bm.checkIn("22", 13);
		bm.checkOut("11", 16);
		bm.checkOut("22", 17);

		Map<String, Integer> employeeTime = bm.getEmployeeTime();
		assertEquals(7, employeeTime.get("11"));
		assertEquals(5, employeeTime.get("22"));
	}

	@Test
	void testWrongEmployeeId() {
		assertThrows(Exception.class, () -> bm.checkIn("999", 9));
	}
}