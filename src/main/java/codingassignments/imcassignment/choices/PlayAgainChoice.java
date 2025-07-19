package codingassignments.imcassignment.choices;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum PlayAgainChoice {
    YES,
    NO;

    public static String getAvailableChoices(){
        return Arrays.stream(values())
                .map(v -> v.name())
                .collect(Collectors.joining(","));
    }
}
