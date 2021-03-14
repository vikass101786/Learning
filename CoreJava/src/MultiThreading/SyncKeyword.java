package MultiThreading;

public class SyncKeyword {
	
	int count = 1;
	
	synchronized public void print(char ch) throws InterruptedException {
		
		for (int i = 0 ; i < 30 ; i++) {
			System.out.print(ch /* +"."+ i +"."+ Thread.currentThread().getName() */);
			//System.out.println(count++ + "||...||" + Thread.currentThread().getName());
		}
		
		Thread.sleep(2000);
		
		for (int i = 30 ; i < 60 ; i++) {
			System.out.print(ch /* +"."+ i +"."+ Thread.currentThread().getName() */ );
			//System.out.println(count++ + "||...||" + Thread.currentThread().getName());
		}
		System.out.println(/* count +"..FINAL..."+ Thread.currentThread().getName() */);
	}
	
	
	public static void print1 (char ch) throws InterruptedException  {
		for (int i = 0 ; i < 30 ; i++) {
			System.out.print(ch + "2");
			//System.out.println(count++ + "||...||" + Thread.currentThread().getName());
		}
		
		Thread.sleep(2000);
		
		for (int i = 30 ; i < 60 ; i++) {
			System.out.print(ch + "1" );
			//System.out.println(count++ + "||...||" + Thread.currentThread().getName());
		}
		System.out.println(/* count +"..FINAL..."+ Thread.currentThread().getName() */);
	}
	
	public static void main(String[] args) {
		SyncKeyword sync = new SyncKeyword();
		SyncKeyword sync1 = new SyncKeyword();
		Thread1 th1 = new Thread1(sync);
		Thread2 th2 = new Thread2(sync1);
		Thread t1 = new Thread(th1);
		Thread t2 = new Thread(th2);
		t1.start();t2.start();
	}
	
}

class Thread1 implements Runnable {
	
	SyncKeyword sync;
	public Thread1(SyncKeyword sync) {
		// TODO Auto-generated constructor stub
		this.sync = sync;
	}
	
	@Override
	public void run() {
	// TODO Auto-generated method stub
		System.out.println("Calling from thread1");
		try {
			sync.print('*');
			SyncKeyword.print1('$');
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


class Thread2 implements Runnable {
	
	SyncKeyword sync;
	public Thread2(SyncKeyword sync) {
		// TODO Auto-generated constructor stub
		this.sync = sync;
	}
	
	@Override
	public void run() {
	// TODO Auto-generated method stub
		System.out.println("Calling from thread2");
		try {
			sync.print('#');
			SyncKeyword.print1('#');
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}