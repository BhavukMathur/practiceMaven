package target2024.basicPractice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Box<T> {
	private T hiddenVal;
}

public class GenericMain {
	public static void main(String[] args) {
		Box<Integer> b1 = new Box();
		Box<String> b2 = new Box();
		b1.setHiddenVal(100);
		b2.setHiddenVal("Sachin");

		System.out.println(b1.getHiddenVal());
		System.out.println(b2.getHiddenVal());
	}
}
