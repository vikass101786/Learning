package MultiThreading;

public class DivByThree {
	
	int i = 1;
	
	
	public synchronized void divBy3() throws InterruptedException {
		for( ; i < 1000 ; i++) {
			while(i % 3 != 0) {
				wait();
			}
			System.out.println(i + " ->  " + Thread.currentThread().getName());
			notify();
		}
	}
	public synchronized void NotdivBy3() throws InterruptedException {
		for( ; i < 1000 ; i++) {
			while(i % 3 == 0) {
				wait();
			}
			System.out.println(i +  " ->  " + Thread.currentThread().getName());
			notify();
		}
	}
	
	
	public static void main(String[] args) {
		
		
		DivByThree divByThree = new DivByThree();
		
		Runnable divBy3 = new Runnable() {
			
			@Override
			public  void run() {
				try {
					divByThree.divBy3();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		
		
		Runnable NotdivBy3 = new Runnable() {
			
			@Override
			public synchronized void run() {
				try {
					divByThree.NotdivBy3();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		};
		
		Thread t1 = new Thread(divBy3);
		t1.setName("Divide By Three");
		Thread t2 = new Thread(NotdivBy3);
		t2.setName("Not Divided By Three");
		t1.start();
		t2.start();
	}

}
