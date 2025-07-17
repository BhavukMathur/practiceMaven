package target2024.systemDesign.movieTicketBooking.price;

import target2024.systemDesign.movieTicketBooking.booking.Ticket;

public interface PricingStrategy {
	Double calculatePrice(Ticket ticket);
}
