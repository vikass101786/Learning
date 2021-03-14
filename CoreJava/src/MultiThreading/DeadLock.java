package MultiThreading;

public class DeadLock {

	public static void main(String[] args) {
		String s1 = "Desktop";
		String s2 = "Laptop";

		Runnable run1 = () -> {

			synchronized (s1) {
				System.out.println(Thread.currentThread().getName());

				synchronized (s2) {
					System.out.println(Thread.currentThread().getName());
				}
			}

		};
		Runnable run2 = () -> {

			synchronized (s2) {
				System.out.println(Thread.currentThread().getName());

				synchronized (s1) {
					System.out.println(Thread.currentThread().getName());
				}

			}
		};

		Thread t1 = new Thread(run1);
		t1.setName("Desktop");
		Thread t2 = new Thread(run2);
		t2.setName("Laptop");
		t1.start();
		t2.start();

	}

}
