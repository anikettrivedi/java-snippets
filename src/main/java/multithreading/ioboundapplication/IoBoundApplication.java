package multithreading.ioboundapplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class IoBoundApplication {

    // TODO - This works, as OS allows allocating 1_000 threads
    private static final int NUMBER_OF_TASKS = 1_000;

    // TODO - This throws Exception, as OS allows can allocate this many threads (limit varies from machine to machine)
    // private static final int NUMBER_OF_TASKS = 10_000;

    public static void main(String[] args) throws InterruptedException {
        System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);
        long start = System.currentTimeMillis();
        performTasks();
        System.out.printf("Tasks took %dms to complete\n", System.currentTimeMillis() - start);
    }

    // TODO - Note from Java 19, ExecutorService implements AutoCloseable, but not for earlier Java Versions
    private static void performTasks() throws InterruptedException {
        // TODO - This threadpool allows as many threads as tasks
        ExecutorService executorService = Executors.newCachedThreadPool();

        // TODO - This threadpool allows only fixed number of threads
        // ExecutorService executorService = Executors.newFixedThreadPool(1_000);

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            executorService.submit(() ->  blockingIoOperation());
        }
        executorService.awaitTermination(2L, TimeUnit.SECONDS);
    }

    // Simulates a long blocking IO
    private static void blockingIoOperation() {
        System.out.println("Executing a blocking task from thread: " + Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}