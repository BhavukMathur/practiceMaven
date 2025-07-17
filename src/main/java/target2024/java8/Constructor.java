package target2024.java8;

class AA {
	AA() {
		System.out.println("A constructor");
	}
}

class BB extends AA {
	BB() {
		System.out.println("B constructor");
	}
}


public class Constructor {
	public static void main(String[] args) {
		AA ab = new BB();
	}
}
