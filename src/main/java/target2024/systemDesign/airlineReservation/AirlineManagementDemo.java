package target2024.systemDesign.airlineReservation;

import target2024.systemDesign.airlineReservation.booking.Ticket;
import target2024.systemDesign.airlineReservation.flight.Flight;
import target2024.systemDesign.airlineReservation.seat.Seat;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class AirlineManagementDemo {
	public static void main(String[] args) {
		AirlineManagementSystem ams = AirlineManagementSystem.getInstance();
		User user1 = new User("Sachin", "sachin@gmail.com");
		User user2 = new User("Ricky", "ponting@gmail.com");
		User user3 = new User("Jacques", "kallis@gmail.com");

		AirCraft a1 = ams.addAirCraft("indigo1", "Indigo", 100);
		AirCraft a2 = ams.addAirCraft("vistara1", "Vistara", 150);

		LocalDateTime departure1 = LocalDateTime.now().plusDays(1).plusHours(6);
		LocalDateTime arrival1 = departure1.plusHours(2);
		//Copy constructor
		Flight flight1 = ams.addFlight("Delhi", "Mumbai", departure1, arrival1, a1, 5000.0);

		LocalDateTime departure2 = LocalDateTime.now().plusDays(2);
		LocalDateTime arrival2 = departure1.plusHours(3);
		Flight flight2 = ams.addFlight("Delhi", "Chennai", departure1, arrival1, a1, 7000.0);

		LocalDateTime departure3 = LocalDateTime.now().plusDays(1).plusHours(12);
		LocalDateTime arrival3 = departure1.plusHours(2);
		Flight flight3 = ams.addFlight("Delhi", "Mumbai", departure1, arrival1, a2, 6000.0);

		//Search Flights
		List<Flight> searchFlightResult = ams.findFlights("Delhi", "Mumbai", LocalDateTime.now().plusDays(1));
		for(Flight flight: searchFlightResult) {
			System.out.println(flight.id + " " + flight.airCraft.getId() + " " + flight.price);
		}

		//Book a flight
		Ticket ticket = ams.bookFlight(searchFlightResult.get(0), user1, new Seat("7A"));
		System.out.println("Ticket booked=" + ticket.getFlight().airCraft.getId() + " " + ticket.getUser().name + " " + ticket.getSeat().getSeatNumber());
	}
}
