package target2024.systemDesign.airlineReservation.booking;

import lombok.Getter;
import target2024.systemDesign.airlineReservation.User;
import target2024.systemDesign.airlineReservation.flight.Flight;
import target2024.systemDesign.airlineReservation.seat.Seat;

import java.util.UUID;

@Getter
public class Ticket {
	String id;
	Flight flight;
	User user;
	Seat seat;
	Double price;

	public Ticket(Flight flight, User user, Seat seat) {
		this.id = UUID.randomUUID().toString();
		this.flight = flight;
		this.user = user;
		this.seat = seat;
		this.price = flight.price;
	}
}
