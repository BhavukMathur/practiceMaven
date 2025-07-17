package target2024.systemDesign.airlineReservation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AirCraft {
	private String id;
	private String airline;
	private Integer totalSeats;
	//Can add the Seats here itself and let flight create a copy of flight
}
