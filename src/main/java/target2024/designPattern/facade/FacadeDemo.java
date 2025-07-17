package target2024.designPattern.facade;

class CPU {
	void start() {
		System.out.println("Starting CPU");
	}
}

class Memory {
	void start() {
		System.out.println("Initializing Memory");
	}
}

class ComputerFacade {
	private CPU cpu;
	private Memory memory;

	ComputerFacade() {
		this.cpu = new CPU();
		this.memory = new Memory();
	}

	void start() {
		System.out.println("Starting computer components");
		cpu.start();
		memory.start();
	}
}

public class FacadeDemo {
	public static void main(String[] args) {
		ComputerFacade cf = new ComputerFacade();
		cf.start();
	}
}
