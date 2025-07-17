package target2024.designPattern.singleton;

public class Singleton {
	private static Singleton obj;

	private Singleton() {

	}

	public static synchronized Singleton getInstance() {
		if(obj == null) {
			obj = new Singleton();
		}
		return obj;
	}

	public void func() {
		System.out.println("From Singleton class");
	}
}
