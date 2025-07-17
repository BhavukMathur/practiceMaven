package target2024.systemDesign.parkingLot.fees;

import target2024.systemDesign.parkingLot.Ticket;

public class FixedFeeStrategy implements FeeStrategy {
	@Override
	public int calculateFees(Ticket ticket) {
		//TODO - Return fees based on ticket
		return 10;
	}
}
