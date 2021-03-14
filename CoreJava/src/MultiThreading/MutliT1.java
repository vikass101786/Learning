package MultiThreading;

public class MutliT1 implements Runnable {
	
	public static int count = 0;
	
	public static void main(String[] args) {
		MutliT1 m1 = new MutliT1();
		Thread t1 = new Thread(m1, "t1");
		Thread t2 = new Thread(m1, "--t2");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		try {
			printTable(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void printTable(int n) throws InterruptedException {
		for (int i = 1 ; i <= 5 ; i++) {
			System.out.println(n* i + " "+ Thread.currentThread().getName());
			Thread.sleep(400);
		}
	}

}
