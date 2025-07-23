package target2024.java8;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
class InventoryItem {
	Integer id;
	@Setter
	Integer quantity;
}

public class InventoryItemStream {
	public static void main(String[] args) {
		List<InventoryItem> items = new LinkedList<>();
		items.add(new InventoryItem(1, 11));
		items.add(new InventoryItem(2, 22));
		items.add(new InventoryItem(3, 33));
		items.add(new InventoryItem(4, 44));
		items.add(new InventoryItem(5, 55));
		
		//Update item quantities with 5
		//No concurrent modification exception because item is not being changed, attribute of an item is.
		//Way1: Using forEach
		items.forEach(item -> item.setQuantity(item.getQuantity() + 5));
		items.forEach(item -> {
			System.out.println(item.getId() + " : " + item.getQuantity());
		});
		
		
		//Way2: Using stream and forEach
		items.stream()
			.forEach(item -> item.setQuantity(item.getQuantity() + 5));
		items.forEach(item -> {
			System.out.println(item.getId() + " : " + item.getQuantity());
		});
		
		
		//Way3: Returning new list
		items = items.stream()
					.map(item -> new InventoryItem(item.getId(), item.getQuantity() + 5))
					.collect(Collectors.toList());
		items.forEach(item -> {
			System.out.println(item.getId() + " : " + item.getQuantity());
		});
	}
}
