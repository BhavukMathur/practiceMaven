package target2024.java8;

@interface CustomJsonField {
	String key() default "default";
}

class Person {
	@CustomJsonField(key = "name")
	private String name;

	@CustomJsonField(key = "age")
	private String age;

	@CustomJsonField()
	private String phone;
}

public class CustomAnnotation {
	public static void main(String[] args) {
		//some code.. ignore
	}
}
