package CustomThreadPool;

public class TaskExecutor implements Runnable {
	CustomBlockingQueue<Runnable> blockingQueue = null;
	public TaskExecutor(CustomBlockingQueue<Runnable> blockingQueue) {
		// TODO Auto-generated constructor stub
		this.blockingQueue=blockingQueue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Thread thread = Thread.currentThread();
			Runnable task;
			try {
				task = blockingQueue.deQueue();
				System.out.println("Task started by thread : => " + thread.getId()+"."+thread.getName());
				task.run();
				System.out.println("Task finished by thread : >= " + thread.getId()+"."+thread.getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
