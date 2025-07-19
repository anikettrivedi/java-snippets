package codingassignment.imcassignment.utility;

import imcassignment.choices.GameChoice;
import imcassignment.choices.PlayAgainChoice;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputUtilsTest {

    InputUtils inputUtils;

    @Test
    void getPlayerName() throws FileNotFoundException {
        inputUtils = new InputUtils(new FileInputStream("src/test/resources/input-1.txt"));
        String playerName = inputUtils.getPlayerName();
        assertEquals("John Doe", playerName);
    }

    @Test
    void getNumberOfRounds() throws FileNotFoundException {
        inputUtils = new InputUtils(new FileInputStream("src/test/resources/input-2.txt"));
        int numberOfRounds = inputUtils.getNumberOfRounds();
        assertEquals(10, numberOfRounds);
    }

    @Test
    void getPlayerChoice() throws FileNotFoundException {
        inputUtils = new InputUtils(new FileInputStream("src/test/resources/input-3.txt"));
        GameChoice playerChoice = inputUtils.getPlayerChoice();
        assertEquals(GameChoice.ROCK, playerChoice);

        inputUtils = new InputUtils(new FileInputStream("src/test/resources/input-4.txt"));
        playerChoice = inputUtils.getPlayerChoice();
        assertEquals(GameChoice.PAPER, playerChoice);

        inputUtils = new InputUtils(new FileInputStream("src/test/resources/input-5.txt"));
        playerChoice = inputUtils.getPlayerChoice();
        assertEquals(GameChoice.SCISSORS, playerChoice);
    }

    @Test
    void inputPlayAgainChoice() throws FileNotFoundException {
        inputUtils = new InputUtils(new FileInputStream("src/test/resources/input-6.txt"));
        PlayAgainChoice playAgainChoice = inputUtils.inputPlayAgainChoice();
        assertEquals(PlayAgainChoice.YES, playAgainChoice);

        inputUtils = new InputUtils(new FileInputStream("src/test/resources/input-7.txt"));
        playAgainChoice = inputUtils.inputPlayAgainChoice();
        assertEquals(PlayAgainChoice.NO, playAgainChoice);
    }
}