package target2024.systemDesign.hotelBooking.room;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import target2024.systemDesign.hotelBooking.Hotel;

public class RoomInventory {
//	String hotelId;
//	RoomType roomType;
//	LocalDate date;
//	Integer totalRooms;
//	Integer bookedRooms;
	Map<String, Integer> roomInventory;
	private final Integer INVENTORY_RANGE = 5;

	public RoomInventory() {
		roomInventory = new LinkedHashMap<>();
	}
	
	public void initializeInventory(Hotel hotel, RoomType roomType, Integer count) {
		//Key: hotelName + roomType + date
		for(int i=0; i<INVENTORY_RANGE; i++) {			
			String key = hotel.getName() + ":" + roomType.name() + ":" + LocalDate.now().plusDays(i);
			roomInventory.put(key, count);
		}
	}
	
	public void showInventory() {
		roomInventory.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
	}
	
	public boolean checkAvailability(Hotel hotel, RoomType roomType, String startDate, String endDate) {
		return true;
	}
	
    public void updateInventory(Hotel hotel, RoomType roomType, String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        while (!start.isAfter(end)) {
            String key = hotel.getName() + ":" + roomType.name() + ":" + start;
            if (roomInventory.containsKey(key)) {
                int currentCount = roomInventory.get(key);
                if (currentCount > 0) {
                    roomInventory.put(key, currentCount - 1);
                } else {
                    System.out.println("No rooms left for: " + key);
                }
            } else {
                System.out.println("No inventory entry found for: " + key);
            }
            start = start.plusDays(1);
        }
    }
}
