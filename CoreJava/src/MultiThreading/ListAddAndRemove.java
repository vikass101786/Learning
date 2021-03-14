package MultiThreading;

import java.util.ArrayList;
import java.util.List;

public class ListAddAndRemove {
	public int capacity ;
	
	 
	List<Integer> list ;
	
	ListAddAndRemove(int capacity) {	
		list = new ArrayList<Integer>();
		this.capacity = capacity;
	}
	
	public synchronized void addElement(Integer data) throws InterruptedException {
		
		while(list.size() == capacity) { // Th1
			wait();
		}
		notifyAll();
		System.out.println(list + " --->  "+ Thread.currentThread().getName());
		list.add(data);
		System.out.println(data + " --->  "+ Thread.currentThread().getName() + "  " + list);
	}
	
	public synchronized void removeElement(Integer data) throws InterruptedException {
		
		while(list.isEmpty()) {  // Th 2
			wait();
		}
		notifyAll();
		System.out.println(list + " " + Thread.currentThread().getName());
		list.remove(data);
		System.out.println(data + " --->  "+ Thread.currentThread().getName() +" " + list);
	}
	
	
 
 
	public static void main(String args []) {
	
		ListAddAndRemove lr = new ListAddAndRemove(10);
		
		Runnable addRunnable = new Runnable() {
		
			public void run() {
			int i = 20;
			 while(i-- > 0) {
					try {
						lr.addElement((int)((Math.random() * 0.33) * 10));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }
			}
		};
		
		Runnable removeRunnable = new Runnable (){
		
			public void run() {
				int i = 20;
				while(i-- > 0) {
				
					try {
						lr.removeElement((int) ((Math.random() * 0.33) * 5));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			}
		
		};
		
		Thread t1 = new Thread(addRunnable);
		t1.setName(" Add ele in list ");
		Thread t2 = new Thread(removeRunnable);
		t2.setName(" Remove ele in list ");
		t1.start();
		t2.start();
	
	
	}
}
