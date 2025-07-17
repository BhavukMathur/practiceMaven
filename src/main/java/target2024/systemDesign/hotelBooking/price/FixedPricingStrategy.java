package target2024.systemDesign.hotelBooking.price;

import java.util.HashMap;
import java.util.Map;

import target2024.systemDesign.hotelBooking.Hotel;
import target2024.systemDesign.hotelBooking.room.RoomType;

public class FixedPricingStrategy implements PricingStrategy {

	static Map<String, Double> pricePerDay = new HashMap<>();
	
	static {
		pricePerDay.put("hotel1:STANDARD", 3000.0);
		pricePerDay.put("hotel1:DELUXE", 5000.0);
		pricePerDay.put("hotel1:SUITE", 10000.0);
	}
	
	
	@Override
	public Double calculatePricePerDay(Hotel hotel, RoomType roomType) {
		String key = hotel.getName() + ":" + roomType.name();
		return pricePerDay.get(key);
	}

}
