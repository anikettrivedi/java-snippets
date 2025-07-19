package codingassignments.imcassignment;


import codingassignments.imcassignment.choices.GameChoice;
import codingassignments.imcassignment.choices.PlayAgainChoice;
import codingassignments.imcassignment.states.GameState;
import codingassignments.imcassignment.stats.Score;
import codingassignments.imcassignment.utility.InputUtils;

import java.io.InputStream;

public class RockPaperScissorsGame {

    private final InputStream source;

    public RockPaperScissorsGame(InputStream source) {
        this.source = source;
    }

    public void start() {

        int numberOfRounds = 0;
        String playerName = "";
        GameState gameState = GameState.GET_NAME;
        GameChoice computerChoice;
        GameChoice playerChoice;
        Score score = null;
        InputUtils inputUtils = new InputUtils(source);

        while (gameState != GameState.TERMINATE) {

            switch (gameState) {

                case GET_NAME:

                    System.out.println("###########################################");
                    System.out.println("Welcome to the game of Rock-Paper-Scissors!");
                    System.out.println("###########################################");

                    playerName = inputUtils.getPlayerName();
                    gameState = gameState.next();

                case START:

                    numberOfRounds = inputUtils.getNumberOfRounds();
                    score = new Score(playerName);
                    gameState = gameState.next();

                case RUNNING:

                    int i = 1;

                    while (i <= numberOfRounds) {

                        System.out.println(String.format("\n******* Round No : %s/%s ***********", i, numberOfRounds));

                        computerChoice = GameChoice.getRandom();
                        playerChoice = inputUtils.getPlayerChoice();

                        System.out.println(String.format("\n\tComputer's Choice: %10s, %s's Choice: %s", computerChoice, playerName, playerChoice));
                        int compare = computerChoice.compareWith(playerChoice);

                        if (compare == 1) {
                            score.incrementComputerScore();
                        } else if (compare == -1) {
                            score.incrementPlayerScore();
                        }
                        score.printScore();
                        i++;
                    }

                    gameState = gameState.next();

                case STOP:

                    score.printResults();
                    PlayAgainChoice choice = inputUtils.inputPlayAgainChoice();

                    if (choice == PlayAgainChoice.YES) {
                        gameState = GameState.START;
                        break;
                    } else {
                        gameState = gameState.next();
                    }

                case TERMINATE:

                    System.out.println("\nIt's been nice playing with you, good bye!");
                    break;

            }
        }
    }
}
