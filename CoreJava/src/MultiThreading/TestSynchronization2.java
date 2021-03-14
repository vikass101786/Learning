package MultiThreading;

class Table {
	synchronized void printTable(int n) {// synchronized method
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i + " " + Thread.currentThread().getName());
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	synchronized void printTableInRev(int n) {// synchronized method
		for (int i = n; i >= 1; i--) {
			System.out.println(n * i + " ~ " + Thread.currentThread().getName());
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}

class MyThread1 extends Thread {
	Table t;

	MyThread1(Table t) {
		this.t = t;
	}

	public void run() {
		 t.printTable(5);
		//Table.printTable(9);
	}

}
class MyThread3 extends Thread {
	Table t;
	
	MyThread3(Table t) {
		this.t = t;
	}
	
	public void run() {
		t.printTableInRev(5);
		//Table.printTableInRev(9);
	}
	
}

class MyThread2 extends Thread {
	Table t;

	MyThread2(Table t) {
		this.t = t;
	}

	public void run() {
		 t.printTable(10);
		//Table.printTable(2);
	}
}

public class TestSynchronization2 {
	public static void main(String args[]) {
		Table obj = new Table();// only one object
		Table obj1 = new Table();
		MyThread1 t1 = new MyThread1(obj);
		MyThread3 t3 = new MyThread3(obj1);
		//MyThread2 t2 = new MyThread2(obj1);
		t1.start();
		t3.start();
		//t2.start();
	}
}