package target2024.systemDesign.hotelBooking.price;

import target2024.systemDesign.hotelBooking.Hotel;
import target2024.systemDesign.hotelBooking.room.RoomType;

public interface PricingStrategy {
	public Double calculatePricePerDay(Hotel hotel, RoomType roomType);
}
