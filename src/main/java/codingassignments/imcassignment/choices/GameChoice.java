package codingassignments.imcassignment.choices;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public enum GameChoice {

    ROCK,
    PAPER,
    SCISSORS;

    // implementing custom compare with as it's not possible to overwrite enum's compareTo method
    public int compareWith(GameChoice c2) {
        if (this.ordinal() == c2.ordinal()) { // tie
            return 0;
        } else if ((this.ordinal() + 1) % values().length == c2.ordinal()) { // player wins (c2)
            return -1;
        } else { // computer wins (this)
            return 1;
        }
    }

    private static Random random = new Random();

    // this method is used to simulate computer's choices
    public static GameChoice getRandom() {
        return values()[random.nextInt(values().length)];
    }

    public static String getAvailableChoices(){
        return Arrays.stream(values())
                .map(v -> v.name())
                .collect(Collectors.joining(","));
    }

}
