package target2024.systemDesign.cargoManagement.shipment;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import target2024.systemDesign.cargoManagement.cargo.Cargo;

@Getter
public class Shipment {
	String id;
	List<Cargo> cargos;
	@Setter
	Vehicle vehicle;
	
	public Shipment() {
		this.id = UUID.randomUUID().toString();
		cargos = new LinkedList<>();
	}
	
	public void addCargo(Cargo cargo) {
		this.cargos.add(cargo);
	}
}
