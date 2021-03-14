import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class UndSemaphore {

    static Semaphore semaphore;

    public static void main(String[] args) throws InterruptedException {
        semaphore = new Semaphore(3);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        IntStream.range(0,50).forEach(i -> executorService.submit(new Task()));
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

    static class Task implements  Runnable {

        @Override
        public void run() {

            try {
                System.out.println("currently allowed permits " + semaphore.availablePermits() +" " +
                        "" + Thread.currentThread().getName() +" currently running thread");
                semaphore.acquire();
                System.out.println(" Accquired semaphore by Thread :: => "
                        + Thread.currentThread().getName() + " ~ " + semaphore.availablePermits() );
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                semaphore.release();
            }
        }
    }

}
