package codingassignments.imcassignment.stats;

import java.util.Objects;

public class Score {

    private int computerScore = 0;
    private int playerScore = 0;
    private final String playerName;

    public Score(String playerName) {
        this.playerName = playerName;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void incrementComputerScore() {
        computerScore++;
    }

    public void incrementPlayerScore() {
        playerScore++;
    }

    public void printScore() {
        System.out.println(String.format("\tComputer's Score : %10s, %s's Score : %s", computerScore, playerName, playerScore));
    }

    public void printResults() {

        System.out.println("\n######################################");
        String winner = null;

        if (computerScore > playerScore) {
            winner = "Computer";
        } else if (playerScore > computerScore) {
            winner = playerName;
        }

        if (Objects.isNull(winner)) {
            System.out.println("\tIt is a tie!");
        } else {
            System.out.println(String.format("\t Winner is %s!", winner));
        }
        System.out.println("######################################");
    }
}
