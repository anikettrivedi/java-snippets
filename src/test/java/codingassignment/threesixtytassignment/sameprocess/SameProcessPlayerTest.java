package codingassignment.threesixtytassignment.sameprocess;

import org.junit.Test;

import java.util.concurrent.Semaphore;

import static org.junit.Assert.assertEquals;

public class SameProcessPlayerTest {

    @Test
    public void testWithOneMaxMessage() throws InterruptedException {

        String[] messageQ = {null};
        Semaphore full = new Semaphore(0);
        Semaphore empty = new Semaphore(1);

        SameProcessPlayer player1 = new SameProcessPlayer("p1", "Hello", messageQ, 1, full, empty);
        SameProcessPlayer player2 = new SameProcessPlayer("p2", null, messageQ, 1, empty, full);

        player1.start();
        player2.start();

        player1.join();
        player2.join();

        assertEquals("Hello | p2 msg#1", messageQ[0]);

    }

    @Test
    public void testWithTwoMaxMessages() throws InterruptedException {

        String[] messageQ = {null};
        Semaphore full = new Semaphore(0);
        Semaphore empty = new Semaphore(1);

        SameProcessPlayer player1 = new SameProcessPlayer("p1", "Hello", messageQ, 2, full, empty);
        SameProcessPlayer player2 = new SameProcessPlayer("p2", null, messageQ, 2, empty, full);

        player1.start();
        player2.start();

        player1.join();
        player2.join();

        assertEquals("Hello | p2 msg#1 | p1 msg#2 | p2 msg#2", messageQ[0]);

    }
}