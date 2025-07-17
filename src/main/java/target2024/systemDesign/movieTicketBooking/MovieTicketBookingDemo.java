package target2024.systemDesign.movieTicketBooking;

import target2024.systemDesign.movieTicketBooking.booking.Ticket;
import target2024.systemDesign.movieTicketBooking.movie.Language;
import target2024.systemDesign.movieTicketBooking.movie.Movie;
import target2024.systemDesign.movieTicketBooking.price.FixedPricingStrategy;
import target2024.systemDesign.movieTicketBooking.price.PricingStrategy;
import target2024.systemDesign.movieTicketBooking.seat.Seat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieTicketBookingDemo {
	public static void main(String[] args) {
		MovieTicketBookingManager bookingManager = MovieTicketBookingManager.getInstance();

		Movie movie1 = bookingManager.addMovie("Infinity-war", Language.ENGLISH);
		Movie movie2 = bookingManager.addMovie("3-Idiots", Language.HINDI);

		Theatre theatre1 = bookingManager.addTheatre("PVR", 10, 10);
		Theatre theatre2 = bookingManager.addTheatre("INOX", 10, 10);

		User user1 = new User("Sachin", "tendulkar@gmail.com");
		User user2 = new User("Ricky", "ponting@gmail.com");

		Show show1 = bookingManager.addShow(movie1, theatre1, LocalDateTime.now(), LocalDateTime.now().plusHours(3));
		Show show2 = bookingManager.addShow(movie2, theatre1, LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(6));

		List<Seat> selectedSeats = new ArrayList<>();
		selectedSeats.add(show1.theatre.getSeats()[0][0]);
		selectedSeats.add(show1.theatre.getSeats()[0][1]);
		selectedSeats.add(theatre1.getSeats()[0][1]);

		PricingStrategy pricingStrategy = new FixedPricingStrategy();
		bookingManager.setPricingStrategy(pricingStrategy);

		try {
			System.out.println("Booking tickets for:" + show1.movie.getTitle()
			+ " time:" + show1.startTime + " theatre:" + show1.theatre.name
			+ " seats:" + selectedSeats.size());
			Ticket ticket1 = bookingManager.bookTicket(user1, show1, selectedSeats);
			System.out.println("Ticket booking initiated:" + ticket1.getId() + " status:" + ticket1.getStatus());
			bookingManager.makePayment(ticket1);
			System.out.println("Ticket booking confirmed:" + ticket1.getId() + " status:" + ticket1.getStatus());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
}
