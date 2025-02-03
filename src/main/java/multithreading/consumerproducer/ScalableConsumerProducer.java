package multithreading.consumerproducer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ScalableConsumerProducer {

    private static final int CAPACITY = 10;

    public static void main(String[] args) throws InterruptedException {
        Semaphore full = new Semaphore(0);
        Semaphore empty = new Semaphore(CAPACITY);
        Queue<Object> queue = new ArrayDeque<>();
        Lock lock = new ReentrantLock();

        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    Object item = new Object();
                    empty.acquire();
                    lock.lock();
                    System.out.println("Producing new item = " + item);
                    queue.offer(item);
                    lock.unlock();
                    full.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    full.acquire();
                    lock.lock();
                    Object item = queue.poll();
                    System.out.println("Consuming item = " + item);
                    lock.unlock();
                    empty.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
