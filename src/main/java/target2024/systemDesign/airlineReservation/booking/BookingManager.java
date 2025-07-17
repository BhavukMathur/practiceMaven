package target2024.systemDesign.airlineReservation.booking;

import lombok.AllArgsConstructor;
import target2024.systemDesign.airlineReservation.User;
import target2024.systemDesign.airlineReservation.flight.Flight;
import target2024.systemDesign.airlineReservation.seat.Seat;

import java.util.HashMap;
import java.util.Map;

public class BookingManager {
	Map<String, Ticket> ticketById;
	private static BookingManager bookingManager = null;

	private BookingManager() {
		ticketById = new HashMap<>();
	}

	public static synchronized BookingManager getInstance() {
		if(bookingManager == null) {
			bookingManager = new BookingManager();
		}
		return bookingManager;
	}

	public Ticket book(Flight flight, User user, Seat seat) {
		Ticket ticket = new Ticket(flight, user, seat);
		ticketById.put(ticket.id, ticket);
		return ticket;
	}
}
