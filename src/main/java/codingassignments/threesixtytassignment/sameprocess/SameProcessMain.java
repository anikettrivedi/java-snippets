package codingassignments.threesixtytassignment.sameprocess;

import java.util.concurrent.Semaphore;

public class SameProcessMain {

    public static void main(String[] args) throws InterruptedException {

        // Simple message queue of size 1 is used
        // queue will allow up to decouple player1 & player2, making graceful shutdown easier
        String[] messageQ = {null};

        Semaphore full = new Semaphore(0);
        Semaphore empty = new Semaphore(1);

        SameProcessPlayer player1 = new SameProcessPlayer("p1", "Hello!", messageQ, 10, full, empty);
        SameProcessPlayer player2 = new SameProcessPlayer("p2", null, messageQ, 10, empty, full);

        player1.start();
        player2.start();

        player1.join();
        player2.join();

    }

}