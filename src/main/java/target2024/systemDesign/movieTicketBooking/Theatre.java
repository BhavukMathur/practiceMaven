package target2024.systemDesign.movieTicketBooking;

import lombok.Getter;
import target2024.systemDesign.movieTicketBooking.seat.Seat;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Getter
public class Theatre {
	String id;
	String name;
//	List<Show> shows;
	Seat[][] seats;
	int row;
	int col;

	public Theatre(String name, int row, int col) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
//		this.shows = new LinkedList<>();
		seats = new Seat[row][col];
		this.row = row;
		this.col = col;

		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				Seat seat = new Seat(i, j, this);
				seats[i][j] = seat;
			}
		}
	}

	public Theatre clone(Theatre theatre) {
		Theatre copyTheatre = new Theatre(theatre.name, theatre.row, theatre.col);
		return copyTheatre;
	}
}
