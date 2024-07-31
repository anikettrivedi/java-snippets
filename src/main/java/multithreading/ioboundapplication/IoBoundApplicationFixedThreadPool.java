package multithreading.ioboundapplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
 * TODO
     * CONCLUSION
         * Application expected runtime is ~ 10 * 1000 * 10 = 10,000 ms, as
             * Threads = 1,000
             * Task Duration = 10 * 100 = 1,000 ms
             * Task Count = 10,000
         * Application actual runtime is > 20,000 due to context switching and other thread allocation/deallocation costs
         * Application doesn't crash if NUMBER OF TASK is very large, as thread pool size is fixed
 * */
public class IoBoundApplicationFixedThreadPool {
    private static final int NUMBER_OF_TASKS = 10_000;

    public static void main(String[] args) {
        System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);

        long start = System.currentTimeMillis();
        performTasks();
        System.out.printf("Tasks took %dms to complete\n", System.currentTimeMillis() - start);
    }

    // TODO - Note from Java 19, ExecutorService implements AutoCloseable, but not for earlier Java Versions
    private static void performTasks() {
        // TODO - Fixed Thread Pool allows as many threads as provided during initialization
        ExecutorService executorService = Executors.newFixedThreadPool(1_000);
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    blockingIoOperation();
                }
            });
        }
    }

    // Simulates a long blocking IO
    private static void blockingIoOperation() {
        System.out.println("Executing a blocking task from thread: " + Thread.currentThread());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}