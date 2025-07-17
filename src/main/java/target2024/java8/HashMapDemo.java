package target2024.java8;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
	public static void main(String[] args) {
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("Sachin", "Tendulkar");
		hashMap.put("Ricky", "Ponting");
		hashMap.put("Jacques", "Kallis");

		for(Map.Entry<String, String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			if(entry.getKey().equals("Ricky")) {
				//This throws ConcurrentModificationException
//				hashMap.remove(entry.getKey());
			}
		}

		hashMap.forEach((key, value) -> {
			if(key.equals("Ricky")) {
				hashMap.put(key, value + "_Aus");
			}
		});

		for(Map.Entry<String, String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
