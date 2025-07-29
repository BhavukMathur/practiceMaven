package target2024.algorithms;

import java.util.*;

//https://leetcode.com/discuss/post/6670715/atlassian-sde-2-karat-round-by-anonymous-km20/
public class RobotParts {
	public static void main(String[] args) {
		List<String> parts = Arrays.asList(
				"Rosie_claw",
				"Rosie_sensors",
				"Dustie_case",
				"Optimus_sensors",
				"Rust_sensors",
				"Rosie_case",
				"Rust_case",
				"Optimus_speaker",
				"Rosie_wheels",
				"Dustie_case",
				"Dustie_arms",
				"Rust_claw",
				"Dustie_case",
				"Dustie_speaker",
				"Optimus_case",
				"Optimus_wheels",
				"Optimus_wheels",
				"Rust_legs",
				"Optimus_sensors"
		);
		
		List<String> available = Arrays.asList("sensors", "case", "speaker", "wheels");
		List<String> result = robots(parts, available);
		result.forEach(resultVal -> {
			System.out.println(resultVal);
		});
	}
	
	private static List<String> robots(List<String> parts, List<String> available) {
		Map<String, Set<String>> robotToParts = new HashMap<>();
		
		String[] temp;
		for(String part: parts) {
			temp = part.split("_");
			Set<String> partSet = robotToParts.getOrDefault(temp[0], new HashSet<>());
			partSet.add(temp[1]);
			robotToParts.put(temp[0], partSet);
		}
		
		robotToParts.forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});
		
		Set<String> availableSet = new HashSet(available);
		
		List<String> result = new LinkedList();
		String part;
		Set<String> partSet;
		for(Map.Entry<String, Set<String>> entry: robotToParts.entrySet()) {
			part = entry.getKey();
			partSet = entry.getValue();
			
			if(available.containsAll(partSet)) {
				result.add(part);
			}
		}
		return result;
	}
	
}
