package target2024.java8;

import lombok.Getter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Uses - Thread-safety, better for key-value usecase, cache
 */
@Getter
final class ImmutablePerson {
	private final String name;
	private final Integer age;
	private final List<String> names;

	ImmutablePerson(String name, Integer age) {
		this.name = name;
		this.age = age;
		this.names = new LinkedList<>();
	}
	
	public void updateNames(String name) {
		names.add(name);
	}
	
	public List<String> getNames() {
		return new LinkedList<>(names);
	}
}

public class Immutable {
	public static void main(String[] args) {
		final List<Integer> mutableList = new LinkedList<>();
		mutableList.add(0); mutableList.add(1); mutableList.add(2);
		System.out.println(mutableList);

		List<Integer> immutableList = Collections.unmodifiableList(mutableList);
		try {
			immutableList.add(3);
		} catch (UnsupportedOperationException uex) {
			System.out.println("Modifying immutable list not allowed");
		}
		System.out.println(immutableList);

		final ImmutablePerson ip = new ImmutablePerson("Sachin", 52);
		System.out.println(ip.getName());
		ip.updateNames("Sachin");
		ip.updateNames("Ponting");
		
		ip.getNames().add("Kallis");
		System.out.println(ip.getNames());
	}
}
