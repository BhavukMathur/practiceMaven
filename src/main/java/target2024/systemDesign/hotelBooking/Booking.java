package target2024.systemDesign.hotelBooking;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import target2024.systemDesign.hotelBooking.room.RoomType;
import target2024.systemDesign.hotelBooking.user.User;

@Getter
public class Booking {
	String id;
	User user;
	Hotel hotel;
	LocalDate checkIn;
	LocalDate checkOut;
	RoomType roomType;
	Double price;
	
	Booking(User user, LocalDate checkIn, LocalDate checkOut, RoomType roomType, Hotel hotel, Double price) {
		this.id = UUID.randomUUID().toString();
		this.user = user;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomType = roomType;
		this.hotel = hotel;
		this.price = price;
	}
}
