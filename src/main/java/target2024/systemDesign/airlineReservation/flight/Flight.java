package target2024.systemDesign.airlineReservation.flight;

import lombok.AllArgsConstructor;
import target2024.systemDesign.airlineReservation.AirCraft;

import java.time.LocalDateTime;
import java.util.UUID;

public class Flight {
	public String id;
	public String source;
	public String destination;
	public LocalDateTime departure;
	public LocalDateTime arrival;
	public AirCraft airCraft;
	public Double price;


	public Flight(String source, String destination, LocalDateTime departure, LocalDateTime arrival, AirCraft airCraft, Double price) {
		this.id = UUID.randomUUID().toString();
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.airCraft = airCraft;
		this.price = price;
	}
}
