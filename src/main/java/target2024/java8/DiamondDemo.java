package target2024.java8;

interface A {
	default void func() {
		System.out.println("Interface A");
	}
}

interface B extends A {
	default void func() {
		System.out.println("Interface B");
	}
}

interface C extends A {
	default void func() {
		System.out.println("Interface C");
	}
}

class D implements B, C {
	@Override
	public void func() {
		C.super.func();
	}
}

public class DiamondDemo {
	public static void main(String[] args) {
		D dd = new D();
		dd.func();
	}

}
