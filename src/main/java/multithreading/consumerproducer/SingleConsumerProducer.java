package multithreading.consumerproducer;

import java.util.concurrent.Semaphore;

public class SingleConsumerProducer {
    public static void main(String[] args) throws InterruptedException {

        Semaphore full = new Semaphore(0);
        Semaphore empty = new Semaphore(1);
        Object[] object = new Object[1];

        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    empty.acquire();
                    object[0] = new Object();
                    System.out.println("producing new object = " + object[0]);
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
                    System.out.println("consuming object = " + object[0]);
                    object[0] = null;
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
