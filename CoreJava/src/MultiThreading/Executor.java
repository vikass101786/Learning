package MultiThreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Executor {

	static List<Task> list = new LinkedList<Task>();

	public static void main(String[] args) throws InterruptedException {
		Task t1 = new Task(1, 2, "u1");
		Task t2 = new Task(3, 4, "u2");
		Task t3 = new Task(5, 6, "u3");
		Task t4 = new Task(7, 8, "u1");
		Task t5 = new Task(9, 10, "u2");
		Task t6 = new Task(11, 12, "u3");
		Task t7 = new Task(13, 14, "u1");
		Task t8 = new Task(15, 16, "u2");
		Task t9 = new Task(17, 18, "u3");

		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);
		list.add(t6);
		list.add(t7);
		list.add(t8);
		list.add(t9);

		
		/*
		 * for (int i = 0 ; i < list.size() ; i++) { int a = list.get(i).a; int b =
		 * list.get(i).b; String username = list.get(i).userName; executor.submit(new
		 * Task(a, b, username)); }
		 * 
		 * Thread.currentThread().join(50);
		 * 
		 * System.out.println(" finalAnswer " + Task.finalAnswer);
		 */
		
		ConcurrentHashMap<String, List<Task>> ch = new ConcurrentHashMap<String, List<Task>>();
		
		for (Task task : list) {
			ch.putIfAbsent(task.userName, new ArrayList<Task>());
			ch.get(task.userName).add(task);
		}
		
		/*
		 * ExecutorService executorMap = Executors.newFixedThreadPool(3);
		 * 
		 * ch. values(). stream(). flatMap(List::stream). forEach(executorMap::submit);
		 */
		
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		 list.forEach(executor::submit);
	        executor.shutdown();
	        while (!executor.isTerminated()) {}
	        System.out.println(" finalAnswer " +  Task.finalAnswer);

	}

	static class Task implements Runnable {

		int a;
		int b;
		String userName;

		public Task(int a, int b, String userName) {
			this.a = a;
			this.b = b;
			this.userName = userName;
			System.out.println(" a " + a + " b " + b + " userName " + userName);
		}

		static AtomicInteger finalAnswer = new AtomicInteger(0);
		
		public ThreadLocal<Integer> userAnswer = new ThreadLocal<Integer>();

		@Override
		public void run() {
			//finalAnswer += (a + b);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finalAnswer.addAndGet((a+b));
			System.out.println(" Thread info " + Thread.currentThread().getName() + " finalAnswer " + finalAnswer + " user-name " + userName);
		}

	}

}
