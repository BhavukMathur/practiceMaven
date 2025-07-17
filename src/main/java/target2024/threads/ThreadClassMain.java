package target2024.threads;

public class ThreadClassMain extends Thread {
	int ind;
	ThreadClassMain(int ind) {
		this.ind = ind;
	}

	public static void main(String[] args) {
		ThreadClassMain[] tarr = new ThreadClassMain[5];

		for(int i=0; i<5; i++) {
			tarr[i] = new ThreadClassMain(i);
			tarr[i].start();
		}
	}

	@Override
	public void run() {
		System.out.println("Thread Started - " + ind);
		System.out.println("Thread Completed - " + ind);
	}
}
