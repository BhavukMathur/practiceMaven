package target2024.systemDesign.airlineReservation.seat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Seat {
	String seatNumber;
	SeatStatus seatStatus;

	public Seat(String seatNumber) {
		this.seatStatus = SeatStatus.AVAILABLE;
		this.seatNumber = seatNumber;
	}

	public void reserve(){
		this.seatStatus = SeatStatus.RESERVED;
	}

	public void book(){
		this.seatStatus = SeatStatus.BOOKED;
	}

	public void release(){
		this.seatStatus = SeatStatus.AVAILABLE;
	}

}
