package target2024.systemDesign.restaurantManagement.table;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Table {
	private String id;
	private Integer capacity;
	TableStatus tableStatus;

	public Table(String id, Integer capacity) {
		this.id = id;
		this.capacity = capacity;
		this.tableStatus = TableStatus.AVAILABLE;
	}

	public synchronized void reserve() throws Exception {
		if(this.getTableStatus() == TableStatus.RESERVED) {
			throw new Exception("Table already booked");
		}
		System.out.println("Table reserved = " + this.id);
		this.setTableStatus(TableStatus.RESERVED);
	}

	public void unReserve() {
		this.setTableStatus(TableStatus.AVAILABLE);
		System.out.println("Table released = " + this.id);
	}
}
