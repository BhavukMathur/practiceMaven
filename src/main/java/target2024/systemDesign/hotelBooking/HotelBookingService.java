package target2024.systemDesign.hotelBooking;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lombok.Setter;
import target2024.systemDesign.hotelBooking.price.PricingStrategy;
import target2024.systemDesign.hotelBooking.room.RoomInventory;
import target2024.systemDesign.hotelBooking.room.RoomType;
import target2024.systemDesign.hotelBooking.user.User;

//Design Pattern: Singleton
public class HotelBookingService {
	
	private static HotelBookingService instance;
	private Map<String, User> userById;
	private Map<String, Hotel> hotelById;
	private RoomInventory roomInventory;
	private List<Booking> bookings;
	
	@Setter
	private PricingStrategy pricingStrategy;
	
	private HotelBookingService() {
		userById = new HashMap<>();
		hotelById = new HashMap<>();
		roomInventory = new RoomInventory();
		bookings = new LinkedList<>();
	}
	
	public synchronized static HotelBookingService getInstance() {
		if(instance == null) {
			instance = new HotelBookingService();
		}
		return instance;
	}
	
	public User createUser(String name) {
		User user = User.createUser(name);
		userById.put(user.getId(), user);
		return user;
	}
	
	public Hotel createHotel(String name) {
		Hotel hotel = new Hotel(name);
		hotelById.put(hotel.getId(), hotel);
		return hotel;
	}
	
	public void initializeInventory(Hotel hotel, RoomType roomType, Integer count) {
		roomInventory.initializeInventory(hotel, roomType, count);
	}
	
	public void showInventory() {
		roomInventory.showInventory();
	}
	
	public Booking book(User user, Hotel hotel, RoomType roomType, String checkIn, String checkOut) {
		boolean isAvailable = roomInventory.checkAvailability(hotel, roomType, checkIn, checkOut);
		
		if(isAvailable) {
			LocalDate checkInDate = LocalDate.parse(checkIn);
			LocalDate checkOutDate = LocalDate.parse(checkOut);
			long numberOfDays = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
			
			Double pricePerDay = pricingStrategy.calculatePricePerDay(hotel, roomType);
			
			Booking booking = new Booking(
					user, checkInDate, checkOutDate, roomType, hotel, (numberOfDays * pricePerDay)
					);
			bookings.add(booking);
			roomInventory.updateInventory(hotel, roomType, checkIn, checkOut);
			return booking;
		} else {
			return null;
		}
	}
}
