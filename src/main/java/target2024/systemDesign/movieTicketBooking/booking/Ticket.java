package target2024.systemDesign.movieTicketBooking.booking;

import lombok.Getter;
import lombok.Setter;
import target2024.systemDesign.movieTicketBooking.Show;
import target2024.systemDesign.movieTicketBooking.User;
import target2024.systemDesign.movieTicketBooking.seat.Seat;

import java.util.List;
import java.util.UUID;

@Getter
public class Ticket {
	String id;
	User user;
	Show show;
	List<Seat> seats;

	public void setPrice(Double price) {
		this.price = price;
	}

	Double price;

	public void confirmTicket() {
		this.status = TicketStatus.CONFIRMED;
	}

	TicketStatus status;

	public Ticket(User user, Show show, List<Seat> seats, TicketStatus status) {
		this.id = UUID.randomUUID().toString();
		this.user = user;
		this.show = show;
		this.seats = seats;
		this.status = status;
	}

}
