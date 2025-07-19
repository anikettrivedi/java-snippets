package codingassignments.threesixtytassignment.differentprocess;

public class DifferentProcessMain {

    public static void main(String[] args) {

        String name = "p1";
        int maxAllowedMessages = 10;
        String message = null;

        try {
            name = args[0];
        } catch (Exception ignored) {}

        try {
            maxAllowedMessages = Integer.parseInt(args[1]);
        } catch (Exception ignored) {}

        try {
            message = args[2];
        } catch (Exception ignored) {}

        DifferentProcessPlayer player = new DifferentProcessPlayer(name, message, maxAllowedMessages, "/tmp/message.txt");
        player.start();

    }
}
