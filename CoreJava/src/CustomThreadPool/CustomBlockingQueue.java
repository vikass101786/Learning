package CustomThreadPool;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue<Vikash> {

	private Queue<Vikash> queue = new LinkedList<Vikash>();
	private int MAX_TASK_IN_QUEUE = -1;
	
	public CustomBlockingQueue(int size) {
		this.MAX_TASK_IN_QUEUE=size;
	}
	
	public synchronized void enqueue(Vikash task) throws InterruptedException {
		// TODO Auto-generated method stub
		while(queue.size() == MAX_TASK_IN_QUEUE) {
			System.out.println(" Queue is FULL !!! You can't enQueue (@ ! @) SO WAIIITTT " + Thread.currentThread().getId() +"."+Thread.currentThread().getName());
			wait();
		}
		
		if(queue.isEmpty()) {
			System.out.println(" Queue is EMPTY !!! HEY THREADS LETS FILLING TASK IN QUEUE (@ ! @) READY ?? " + Thread.currentThread().getId() +"."+Thread.currentThread().getName());
			notifyAll();
		}
		queue.offer(task);
	}

	public synchronized Vikash deQueue() throws InterruptedException {
		// TODO Auto-generated method stub
		while(queue.isEmpty()) {
			System.out.println(" Queue is Empty !!! You can't dequeue (@ ! @) SO WAIIITTT " + Thread.currentThread().getId() +"."+Thread.currentThread().getName());
			wait();
		}
		
		if(queue.size() == MAX_TASK_IN_QUEUE)
			System.out.println(" Queue is Full Now !!! HEY THREADS !!! LET's GET INTO WORK " + Thread.currentThread().getId() +"."+Thread.currentThread().getName());
			notifyAll();
		
		return queue.poll();
	}

}
