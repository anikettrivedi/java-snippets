package codingassignments.threesixtytassignment.differentprocess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class DifferentProcessPlayer {

    private final String name;
    private String message;
    private final int maxAllowedMessages;
    private final String tmpFilePath;
    private int counter = 0;

    public DifferentProcessPlayer(
            String name,
            String message,
            int maxAllowedMessages,
            String tmpFilePath
    ) {
        this.maxAllowedMessages = maxAllowedMessages;
        this.name = name;
        this.message = message;
        this.tmpFilePath = tmpFilePath;

        if (!Objects.isNull(message)) { // initiator

            // cleanup any old files
            try {
                Files.delete(Paths.get(tmpFilePath));
            } catch (IOException ignored) {}

            counter++;
            System.out.printf("%s : %s%n", name, message);
            writeMessageToFile(message);
        }

    }

    public void start() {
        while (counter < maxAllowedMessages) {

            // read message from file
            String messageFromFile = readMessageFromFile();

            // check if messageFromFile is same as message, if same then sleep for some time, as other process has yet to update the message
            if (messageFromFile.equals(message)) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {}
                continue;
            }

            // increment the counter
            counter++;

            // updating the message by concatenating received message with senders message count before sending
            message =  String.format("%s | %s msg#%s", messageFromFile, name, counter);

            System.out.printf("%s : %s%n", name, message);
            writeMessageToFile(message);
        }
    }

    private void writeMessageToFile(String message) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(tmpFilePath);
        ) {
            fileOutputStream.write(message.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ignored) {}
    }

    private String readMessageFromFile() {
        try (
                FileInputStream fileInputStream = new FileInputStream(tmpFilePath);
        ) {
            byte[] bytes = fileInputStream.readAllBytes();
            return new String(bytes);
        } catch (IOException ignored) {}
        return null;
    }

}
