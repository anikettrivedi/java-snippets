package codingassignments.imcassignment.states;

public enum GameState {
    GET_NAME,
    START,
    RUNNING,
    STOP,
    TERMINATE;

    public GameState next(){
        return values()[(this.ordinal() + 1) % values().length];
    }
}
