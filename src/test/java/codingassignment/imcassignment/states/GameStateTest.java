package codingassignment.imcassignment.states;

import org.junit.jupiter.api.Test;

class GameStateTest {

    @Test
    void next() {
        assertEquals(GameState.START, GameState.GET_NAME.next());
        assertEquals(GameState.RUNNING, GameState.START.next());
        assertEquals(GameState.STOP, GameState.RUNNING.next());
        assertEquals(GameState.TERMINATE, GameState.STOP.next());
        assertEquals(GameState.GET_NAME, GameState.TERMINATE.next());
    }
}