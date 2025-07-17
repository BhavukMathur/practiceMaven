package target2024.systemDesign.movieTicketBooking;

import target2024.systemDesign.movieTicketBooking.booking.Ticket;
import target2024.systemDesign.movieTicketBooking.booking.TicketStatus;
import target2024.systemDesign.movieTicketBooking.movie.Language;
import target2024.systemDesign.movieTicketBooking.movie.Movie;
import target2024.systemDesign.movieTicketBooking.price.PricingStrategy;
import target2024.systemDesign.movieTicketBooking.seat.Seat;
import target2024.systemDesign.movieTicketBooking.seat.SeatStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Singleton design pattern
public class MovieTicketBookingManager {
	private static MovieTicketBookingManager instance;
	List<Movie> movies;
	List<Theatre> theatres;
	Map<String, Show> showsById;
	Map<String, Ticket> ticketsById;
	PricingStrategy pricingStrategy;

	private MovieTicketBookingManager() {
		movies = new LinkedList<>();
		theatres = new LinkedList<>();
		showsById = new HashMap<>();
		ticketsById = new HashMap<>();
	}

	public synchronized static MovieTicketBookingManager getInstance() {
		if(instance == null) {
			instance = new MovieTicketBookingManager();
		}
		return instance;
	}

	public Movie addMovie(String name, Language language) {
		Movie movie = new Movie(name, language);
		movies.add(movie);
		return movie;
	}

	public Theatre addTheatre(String name, int row, int col) {
		Theatre theatre = new Theatre(name, row, col);
		theatres.add(theatre);
		return theatre;
	}

	public Show addShow(Movie movie, Theatre theatre, LocalDateTime startTime, LocalDateTime endTime) {
		Theatre copyTheatre = theatre.clone(theatre);
		Show show = new Show(movie, copyTheatre, startTime, endTime);
		showsById.put(show.id, show);
		return show;
	}

	public Ticket bookTicket(User user, Show show, List<Seat> seats) throws Exception {
		validateSeats(seats);
		Ticket ticket = new Ticket(user, show, seats, TicketStatus.PENDING);
		ticketsById.put(ticket.getId(), ticket);
		return ticket;
	}

	private void validateSeats(List<Seat> seats) throws Exception {
		for (Seat seat: seats) {
			if(seat.getStatus() != SeatStatus.AVAILABLE) {
				throw new Exception("Seat not available");
			}
		}
	}

	public synchronized Ticket makePayment(Ticket ticket) {
		Double perSeatPrice = pricingStrategy.calculatePrice(ticket);
		Double total = perSeatPrice * ticket.getSeats().size();
		//Payment done
		ticket.setPrice(total);
		ticket.confirmTicket();
		return ticket;
	}

	public void setPricingStrategy(PricingStrategy strategy) {
		this.pricingStrategy = strategy;
	}

}
