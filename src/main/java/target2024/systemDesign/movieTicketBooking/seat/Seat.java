package target2024.systemDesign.movieTicketBooking.seat;

import lombok.Getter;
import target2024.systemDesign.movieTicketBooking.Show;
import target2024.systemDesign.movieTicketBooking.Theatre;

import java.util.UUID;

@Getter
public class Seat {
	String id;
	Integer rowNum;
	Integer colNum;
	Theatre theatre;
	SeatStatus status;

	public Seat(Integer rowNum, Integer colNum, Theatre theatre) {
		this.id = UUID.randomUUID().toString();
		this.rowNum = rowNum;
		this.colNum = colNum;
		this.theatre = theatre;
		this.status = SeatStatus.AVAILABLE;
	}
}
