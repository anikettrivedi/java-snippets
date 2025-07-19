package codingassignment.imcassignment.choices;

import org.junit.jupiter.api.Test;

class GameChoiceTest {

    @Test
    void compareWith() {
        assertEquals(-1, GameChoice.ROCK.compareWith(GameChoice.PAPER)); // paper beats rock
        assertEquals(-1, GameChoice.PAPER.compareWith(GameChoice.SCISSORS)); // scissors beats paper
        assertEquals(-1, GameChoice.SCISSORS.compareWith(GameChoice.ROCK)); // rock beats scissors

        assertEquals(0, GameChoice.ROCK.compareWith(GameChoice.ROCK)); // tie
        assertEquals(0, GameChoice.PAPER.compareWith(GameChoice.PAPER)); // tie
        assertEquals(0, GameChoice.SCISSORS.compareWith(GameChoice.SCISSORS)); // tie

        assertEquals(1, GameChoice.ROCK.compareWith(GameChoice.SCISSORS)); // rock beats scissors
        assertEquals(1, GameChoice.PAPER.compareWith(GameChoice.ROCK)); // paper beats rock
        assertEquals(1, GameChoice.SCISSORS.compareWith(GameChoice.PAPER)); // scissors beats paper
    }
}