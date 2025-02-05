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

        Runnable producer = new Thread(() -> {
            while (true) {
                try {
                    Object item = new Object();
                    empty.acquire();
                    lock.lock();
                    System.out.printf("Thread = %s, Producing Item = %s%n", Thread.currentThread().getName(), item);
                    queue.offer(item);
                    lock.unlock();
                    full.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Runnable consumer = new Thread(() -> {
            while (true) {
                try {
                    full.acquire();
                    lock.lock();
                    Object item = queue.poll();
                    System.out.printf("Thread = %s, Consuming Item = %s%n", Thread.currentThread().getName(), item);
                    lock.unlock();
                    empty.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread[] producers = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(producer);
            thread.setName("Producer-Thread-" + i);
            producers[i] = thread;
        }

        Thread[] consumers = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(consumer);
            thread.setName("Consumer-Thread-" + i);
            consumers[i] = thread;
        }

        for (Thread t : producers) {
            t.start();
        }

        for (Thread t : consumers) {
            t.start();
        }

        for (Thread t : producers) {
            t.join();
        }

        for (Thread t : consumers) {
            t.join();
        }
    }
}
