package target2024.threads;

public class RunnableInterfaceMain implements Runnable {
	int ind;
	RunnableInterfaceMain(int ind) {
		this.ind = ind;
	}

	public static void main(String[] args) {
		RunnableInterfaceMain[] iarr = new RunnableInterfaceMain[5];
		Thread[] tarr = new Thread[5];

		System.out.println("Main thread started");
		for(int i=0; i<5; i++) {
			iarr[i] = new RunnableInterfaceMain(i);
			tarr[i] = new Thread(iarr[i]);
			tarr[i].start();
		}
		System.out.println("Main thread completed");
	}

	@Override
	public void run() {
		System.out.println("Thread - " + ind + " Started");
		System.out.println("Thread - " + ind + " Completed");
	}
}
