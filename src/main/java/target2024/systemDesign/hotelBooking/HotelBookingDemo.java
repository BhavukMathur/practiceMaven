package target2024.systemDesign.hotelBooking;

import java.time.LocalDate;

import target2024.systemDesign.hotelBooking.price.FixedPricingStrategy;
import target2024.systemDesign.hotelBooking.price.PricingStrategy;
import target2024.systemDesign.hotelBooking.room.RoomType;
import target2024.systemDesign.hotelBooking.user.User;

public class HotelBookingDemo {
	public static void main(String[] args) {
		HotelBookingService service = HotelBookingService.getInstance();
		PricingStrategy strategy = new FixedPricingStrategy();
		service.setPricingStrategy(strategy);
		
		User user1 = service.createUser("user1");
		
		//Register hotels
		Hotel hotel1 = service.createHotel("hotel1");
		service.initializeInventory(hotel1, RoomType.STANDARD, 3);
		service.initializeInventory(hotel1, RoomType.DELUXE, 5);
		service.initializeInventory(hotel1, RoomType.SUITE, 2);
		
		//Date + HotelId + RoomType --> RoomInventory
		service.showInventory();		
		Booking booking = service.book(user1, hotel1, RoomType.DELUXE, "2025-06-30", "2025-07-02");
		System.out.println("Booking done..!!. Amount = " + booking.getPrice());
		service.showInventory();
	}
}
