package target2024.systemDesign.cargoManagement.cargo;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import target2024.systemDesign.cargoManagement.User;

@Getter
public class Cargo {
	String id;
	User sender;
	User receiver;
	String sourceAddress;
	String destAddress;
	Double weight;
	Double amount;
	CargoStatus status;
	List<TrackingInfo> trackingInfo;
	
	public Cargo(User sender, User receiver, String sourceAddress, String destAddress, Double weight,
			CargoStatus status, Double amount) {
		this.id = UUID.randomUUID().toString();
		this.sender = sender;
		this.receiver = receiver;
		this.sourceAddress = sourceAddress;
		this.destAddress = destAddress;
		this.weight = weight;
		this.status = status;
		trackingInfo = new LinkedList<>();
		this.amount = amount;
	}
	
}
