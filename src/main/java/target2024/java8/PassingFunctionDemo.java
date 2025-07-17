package target2024.java8;

class Foo {
	
	public void handle1() {
		impl1();
	} 

	public void handle2() {
		common(this::handle2, this::impl2);
	} 
	
	private void impl1() {
		System.out.println("impl1");
	}


	private void impl2() {
		System.out.println("impl2");
	}
	
	private void common(Runnable handle, Runnable impl) {
		System.out.println("Inside common method via: " + handle);	//Name can't be passed as such
		impl.run();
	}
}

public class PassingFunctionDemo {
	public static void main(String[] args) {
		Foo foo = new Foo();
		foo.handle2();
	}
}
