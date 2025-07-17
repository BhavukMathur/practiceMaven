package target2024.designPattern.builder;

class Car {
	private String brand;
	private String model;
	private String engineType;
	private String color;

	private Car(Builder builder) {
		this.brand = builder.brand;
		this.model = builder.model;
		this.engineType = builder.engineType;
		this.color = builder.color;
	}

	@Override
	public String toString() {
		return "Car{" +
				"brand='" + brand + '\'' +
				", model='" + model + '\'' +
				", engineType='" + engineType + '\'' +
				", color='" + color + '\'' +
				'}';
	}

	public static class Builder {
		private String brand;
		private String model;
		private String engineType;
		private String color;

		public Builder brand(String brand) {
			this.brand = brand;
			return this;
		}

		public Builder model(String model) {
			this.model = model;
			return this;
		}

		public Builder engineType(String engineType) {
			this.engineType = engineType;
			return this;
		}

		public Builder color(String color) {
			this.color = color;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}
}


public class BuilderDemo {
	public static void main(String[] args) {
		Car car = new Car.Builder()
				.brand("Toyota")
				.model("Corolla")
				.engineType("Petrol")
				.color("Red")
				.build();

		System.out.println(car);
	}
}
