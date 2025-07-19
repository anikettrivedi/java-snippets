package codingassignment.threesixtytassignment.differentprocess;

import org.junit.Test;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class DifferentProcessPlayerTest {

    @Test
    public void test() {
        DifferentProcessPlayer player = new DifferentProcessPlayer("p1", "Hello", 1, "src/test/resources/message.txt");
        player.start();
        String actual = null;
        try (
                FileInputStream fileInputStream = new FileInputStream("src/test/resources/message.txt")
        ) {
            actual = new String(fileInputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception ignored) {
        }
        assertEquals("Hello", actual);

        DifferentProcessPlayer player2 = new DifferentProcessPlayer("p2", null, 1, "src/test/resources/message.txt");
        player2.start();
        actual = null;
        try (
                FileInputStream fileInputStream = new FileInputStream("src/test/resources/message.txt")
        ) {
            actual = new String(fileInputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception ignored) {
        }
        assertEquals("Hello | p2 msg#1", actual);
    }

}