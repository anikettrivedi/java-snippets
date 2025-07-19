package codingassignment.imcassignment;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class RockPaperScissorsGameTest {

    RockPaperScissorsGame rockPaperScissorsGame;

    @Test
    void start() throws FileNotFoundException {
        // in this test we are not asserting anything, but we are validating that the game starts & ends properly
        rockPaperScissorsGame = new RockPaperScissorsGame(new FileInputStream("src/test/resources/input-8.txt"));
        rockPaperScissorsGame.start();

        rockPaperScissorsGame = new RockPaperScissorsGame(new FileInputStream("src/test/resources/input-9.txt"));
        rockPaperScissorsGame.start();
    }
}