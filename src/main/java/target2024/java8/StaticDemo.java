package target2024.java8;

class Parent {
	static String obj = "ParentObj";
	public static void func() {
		System.out.println("Parent");
	}
}

class Child extends Parent {
	static String obj = "ChildObj";
	public static void func() {
		System.out.println("Parent");
	}
}

public class StaticDemo {
	public static void main(String[] args) {
		Parent p = new Child();
		p.func();
		System.out.println(p.obj);
	}
}
