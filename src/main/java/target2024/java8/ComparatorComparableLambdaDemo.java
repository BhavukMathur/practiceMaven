package target2024.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Student1 implements Comparable<Student1> {

	String name;
	
	@Override
	public int compareTo(Student1 o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
	
}

@AllArgsConstructor
class Student2 {
	String name;
}

class Student2Sort implements Comparator<Student2> {

	@Override
	public int compare(Student2 o1, Student2 o2) {
		return (o1.name.compareTo(o2.name));
	}
	
}

public class ComparatorComparableLambdaDemo {
	public static void main(String[] args) {
		Student1 s11 = new Student1("sachin");
		Student1 s12 = new Student1("ponting");
		Student1 s13 = new Student1("kallis");
		Student1 s14 = new Student1("lara");
		List<Student1> sl1 = Arrays.asList(s11, s12, s13, s14);
		
		Student2 s21 = new Student2("sachin");
		Student2 s22 = new Student2("ponting");
		Student2 s23 = new Student2("kallis");
		Student2 s24 = new Student2("lara");
		List<Student2> sl2 = Arrays.asList(s21, s22, s23, s24);

		//Sorting both the lists
		System.out.println("-- Comparable (Same class) - 1 compareTo");
		Collections.sort(sl1);
		sl1.forEach(item -> {
			System.out.print(item.name + " ");
		});
		System.out.println();

		System.out.println("-- Comparator (Separate) - 2 new Class");
		Collections.sort(sl2, new Student2Sort());
		sl2.forEach(item -> {
			System.out.print(item.name + " ");
		});
	}
}
