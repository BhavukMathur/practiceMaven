package target2024.systemDesign.cargoManagement;

import java.util.Arrays;

import target2024.systemDesign.cargoManagement.cargo.Cargo;
import target2024.systemDesign.cargoManagement.shipment.Shipment;
import target2024.systemDesign.cargoManagement.shipment.Vehicle;
import target2024.systemDesign.cargoManagement.shipment.VehicleType;
import target2024.systemDesign.cargoManagement.shipment.strategy.WeightBasedAssignmentStrategy;

public class CargoDemo {

	public static void main(String[] args) {
		CargoService service = CargoService.getInstance();
		WeightBasedAssignmentStrategy strategy = new WeightBasedAssignmentStrategy();
		service.setStrategy(strategy);
		
		Vehicle van1 = service.registerVehicle("van11", VehicleType.VAN);
		Vehicle van2 = service.registerVehicle("van22", VehicleType.VAN);
		Vehicle truck1 = service.registerVehicle("truck22", VehicleType.TRUCK);
		
		User sourceUser = service.createUser("sourceUser");
		User destUser = service.createUser("destUser");
		
		Cargo cargo1 = service.createCargo(sourceUser, destUser, "source add", "dest addr", 5.0, 500.0);
		Cargo cargo2 = service.createCargo(sourceUser, destUser, "source add", "dest addr", 3.0, 300.0);
		Cargo cargo3 = service.createCargo(sourceUser, destUser, "source add", "dest addr", 10.0, 1500.0);
		
		Shipment shipment = service.createShipment(Arrays.asList(cargo1, cargo2, cargo3));
		
		System.out.println("Shipment created..!!");
		System.out.println(shipment.getId() + " : " + shipment.getVehicle().getVehicleType() + " : " 
								+ shipment.getVehicle().getRegNumber());
		
		Shipment shipment2 = service.createShipment(Arrays.asList(cargo1, cargo2, cargo3));
		System.out.println(shipment2.getId() + " : " + shipment2.getVehicle().getVehicleType() + " : " 
				+ shipment2.getVehicle().getRegNumber());
		Shipment shipment3 = service.createShipment(Arrays.asList(cargo1, cargo2, cargo3));
		System.out.println(shipment3.getId() + " : " + shipment3.getVehicle().getVehicleType() + " : " 
				+ shipment3.getVehicle().getRegNumber());
		
		//Update cargo/shipment status		
	}

}
