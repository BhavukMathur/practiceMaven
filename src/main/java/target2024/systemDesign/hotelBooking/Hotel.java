package target2024.systemDesign.hotelBooking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import lombok.Getter;
import target2024.systemDesign.hotelBooking.room.Room;
import target2024.systemDesign.hotelBooking.room.RoomType;

@Getter
public class Hotel {
	String id;
	String name;
	Map<RoomType, Integer> priceByRoom;
	
	public Hotel(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		priceByRoom = new HashMap<>();
	}
}
