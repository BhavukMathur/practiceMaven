package target2024.systemDesign.cargoManagement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import lombok.Setter;
import target2024.systemDesign.cargoManagement.cargo.Cargo;
import target2024.systemDesign.cargoManagement.cargo.CargoStatus;
import target2024.systemDesign.cargoManagement.shipment.Shipment;
import target2024.systemDesign.cargoManagement.shipment.Vehicle;
import target2024.systemDesign.cargoManagement.shipment.VehicleType;
import target2024.systemDesign.cargoManagement.shipment.strategy.VehicleAssignmentStrategy;

public class CargoService {
	private static CargoService instance;
	@Setter
	private VehicleAssignmentStrategy strategy;
	Map<VehicleType, Queue<Vehicle>> vehiclesByType;
	
	private CargoService() {
		vehiclesByType = new HashMap<>();
	}
	
	public synchronized static CargoService getInstance() {
		if(instance == null) {
			instance = new CargoService();
		}
		return instance;
	}
	
	public User createUser(String name) {
		return User.createUser(name);
	}
	
	public Cargo createCargo(User sender, User receiver, String sourceAddress, String destAddress, Double weight,
			Double amount) {
		Cargo cargo = new Cargo(sender, receiver, sourceAddress, destAddress, weight, CargoStatus.BOOKED, amount);
		return cargo;
	}
	
	public Shipment createShipment(List<Cargo> cargos) {
		Shipment shipment = new Shipment();
		
		//Add cargos
		cargos.forEach(cargo -> {
			shipment.addCargo(cargo);
		});
		
		//Assign vehicle
		VehicleType vehicleType = strategy.assignVehicle(shipment);
		Vehicle vehicle = vehiclesByType.get(vehicleType).poll();
		vehiclesByType.get(vehicleType).add(vehicle);
		
		shipment.setVehicle(vehicle);
		
		return shipment;
	}
	
	
	public Vehicle registerVehicle(String regNumber, VehicleType vehicleType) {
		Vehicle vehicle = new Vehicle(regNumber, vehicleType);
		Queue vehicleQueue = vehiclesByType.getOrDefault(vehicleType, new LinkedList<>());
		vehicleQueue.add(vehicle);
		vehiclesByType.put(vehicleType, vehicleQueue);
		return vehicle;
	}
	
	
}
