package target2024.systemDesign.cargoManagement.cargo;

import java.time.LocalDateTime;
import java.util.List;

public class TrackingInfo {
	CargoStatus status;
	LocalDateTime timeStamp;
	
	TrackingInfo(CargoStatus status, LocalDateTime timeStamp) {
		this.status = status;
		this.timeStamp = timeStamp;
	}
}
