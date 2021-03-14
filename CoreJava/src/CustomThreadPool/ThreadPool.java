package CustomThreadPool;

public class ThreadPool {
	
	CustomBlockingQueue<Runnable> blockingQueue = null;
	
	int size;
	int nThread;
	
	public ThreadPool(int size, int nThread) {
		this.size=size;
		this.nThread=nThread;
		blockingQueue = new CustomBlockingQueue(size);
		String threadName = null;
		TaskExecutor taskExecutor = null;
		for (int count = 0; count < nThread ; count++) {
			threadName = "[ thread :: " + count +" ] ";
			taskExecutor = new TaskExecutor(blockingQueue);
			Thread thread = new Thread(taskExecutor, threadName);
			thread.start();
		}
	}
	
	public void submitTask(Runnable task) throws InterruptedException {
		blockingQueue.enqueue(task);
	}
	

}
