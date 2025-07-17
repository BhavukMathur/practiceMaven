package target2024.systemDesign.airlineReservation;

import target2024.systemDesign.airlineReservation.booking.BookingManager;
import target2024.systemDesign.airlineReservation.booking.Ticket;
import target2024.systemDesign.airlineReservation.flight.Flight;
import target2024.systemDesign.airlineReservation.seat.Seat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Singleton design pattern
public class AirlineManagementSystem {

	private static AirlineManagementSystem instance = null;

	Map<String, AirCraft> airCraftsById;
	Map<String, Flight> flightsById;
	BookingManager bookingManager;

	private AirlineManagementSystem() {
		airCraftsById = new HashMap<>();
		flightsById = new HashMap<>();
		bookingManager = BookingManager.getInstance();
	}

	public synchronized static AirlineManagementSystem getInstance() {
		if(instance == null) {
			instance = new AirlineManagementSystem();
		}
		return instance;
	}

	public Flight addFlight(
			String source, String destination, LocalDateTime departure, LocalDateTime arrival, AirCraft airCraft, Double price
	) {
		Flight flight = new Flight(source, destination, departure, arrival, airCraft, price);
		flightsById.put(flight.id, flight);
		return flight;
	}

	public AirCraft addAirCraft(String id, String airline, Integer totalSeats) {
		AirCraft airCraft = new AirCraft(id, airline, totalSeats);
		airCraftsById.put(id, airCraft);
		return airCraft;
	}

	public List<Flight> findFlights(String source, String destination, LocalDateTime startTime) {
		List<Flight> result = new ArrayList<>();
		for(Map.Entry<String, Flight> entry : flightsById.entrySet()) {
			if(entry.getValue().source.equals(source)
			&& entry.getValue().destination.equals(destination)
			&& entry.getValue().departure.isAfter(startTime)) {
				result.add(entry.getValue());
			}
		}
		return result;
	}

	public synchronized Ticket bookFlight(Flight flight, User user, Seat seat) {
		return bookingManager.book(flight, user, seat);
	}
}
