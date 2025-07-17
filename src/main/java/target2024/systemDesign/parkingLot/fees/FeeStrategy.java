package target2024.systemDesign.parkingLot.fees;

import target2024.systemDesign.parkingLot.Ticket;

public interface FeeStrategy {
	int calculateFees(Ticket ticket);
}
