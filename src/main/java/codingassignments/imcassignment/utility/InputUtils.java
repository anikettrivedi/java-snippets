package codingassignments.imcassignment.utility;

import imcassignment.choices.GameChoice;
import imcassignment.choices.PlayAgainChoice;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class InputUtils {

    private final Scanner scanner;

    public InputUtils(InputStream source) {
        this.scanner = new Scanner(source);
    }

    public String getPlayerName(){
        System.out.println("\nWhat's your name?");
        String playerName = scanner.nextLine().trim();
        System.out.println(String.format("Hello %s! Nice to meet you!", playerName));
        return playerName;
    }

    public int getNumberOfRounds() {
        System.out.println("\nHow many rounds would you like to play?");
        int n = 0;
        while (n <= 0) {
            try {
                String input = scanner.nextLine().trim();
                n = Integer.parseInt(input);
                if (n <= 0) {
                    throw new IllegalArgumentException();
                }
                if (n > 25) {
                    System.out.println("It is going to be exhausting!!!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(String.format("Uh oh! Looks like your input is invalid, please provide me a valid number (> 0 & < %s) :", Integer.MAX_VALUE));
            }
        }
        System.out.println("Lets get going then!");
        return n;
    }

    public GameChoice getPlayerChoice() {
        System.out.println(String.format("\nWhat's your choice (%s)?", GameChoice.getAvailableChoices()));
        GameChoice choice = null;
        while (Objects.isNull(choice)) {
            try {
                String input = scanner.nextLine().trim().toUpperCase();
                choice = GameChoice.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println(String.format("Hmm, please enter a valid choice (%s).", GameChoice.getAvailableChoices()));
            }
        }
        return choice;
    }

    public PlayAgainChoice inputPlayAgainChoice(){
        System.out.println(String.format("\nWanna play again? (%s)?", PlayAgainChoice.getAvailableChoices()));
        PlayAgainChoice choice = null;
        while(Objects.isNull(choice)) {
            try {
                String input = scanner.nextLine().trim().toUpperCase();
                choice = PlayAgainChoice.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println(String.format("Please enter a valid choice. (%s)?", PlayAgainChoice.getAvailableChoices()));
            }
        }
        return choice;
    }

}
