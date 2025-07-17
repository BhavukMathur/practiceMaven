package target2024.systemDesign.movieTicketBooking.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Movie {
	String id;
	String title;
	Language language;

	public Movie(String title, Language language) {
		this.id = UUID.randomUUID().toString();
		this.title = title;
		this.language = language;
	}
}
