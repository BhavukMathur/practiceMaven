package target2024.systemDesign.movieTicketBooking;

import lombok.Getter;
import target2024.systemDesign.airlineReservation.seat.Seat;
import target2024.systemDesign.movieTicketBooking.movie.Movie;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Show {
	String id;
	Movie movie;
	Theatre theatre;
	LocalDateTime startTime;
	LocalDateTime endTime;
//	Map<Seat, User> seatUserMap;

	public Show(Movie movie, Theatre theatre, LocalDateTime startTime, LocalDateTime endTime) {
		this.movie = movie;
		this.theatre = theatre;
		this.startTime = startTime;
		this.endTime = endTime;
//		this.seatUserMap = new HashMap<>();
	}
}
