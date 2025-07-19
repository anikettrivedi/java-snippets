package codingassignments.threesixtytassignment.sameprocess;

import java.util.Objects;
import java.util.concurrent.Semaphore;

public class SameProcessPlayer extends Thread {

    private final String message;
    private final String[] messageQ;
    private final int maxAllowedMessages;
    private final Semaphore full;
    private final Semaphore empty;

    private int counter = 0;

    public SameProcessPlayer(
            String name,
            String message,
            String[] messageQ,
            int maxAllowedMessages,
            Semaphore full,
            Semaphore empty
    ) {
        super(name);
        this.message = message;
        this.messageQ = messageQ;
        this.full = full;
        this.empty = empty;
        this.maxAllowedMessages = maxAllowedMessages;
    }

    @Override
    public void run(){

        // This will be executed only once by initiator (player 1)
        if (!Objects.isNull(message)) {
            try {
                empty.acquire();
                counter++;
                messageQ[0] = message;
                System.out.printf("%s : %s%n", this.getName(), messageQ[0]);
                full.release();
            } catch (InterruptedException ignored) {}
        }

        // this will be executed alternatively by player 1 & player 2
        while (counter < maxAllowedMessages) {
            try {
                empty.acquire();
                counter++;
                // updating the message by concatenating received message with senders message count before sending
                messageQ[0] = String.format("%s | %s msg#%s", messageQ[0], this.getName(), counter);
                System.out.printf("%s : %s%n", this.getName(), messageQ[0]);
                full.release();
            } catch (InterruptedException ignored) {}
        }
    }


}
