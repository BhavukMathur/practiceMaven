package target2024.systemDesign.movieTicketBooking.price;

import target2024.systemDesign.movieTicketBooking.booking.Ticket;

public class FixedPricingStrategy implements PricingStrategy {
	@Override
	public Double calculatePrice(Ticket ticket) {
		return 300.0;
	}
}
