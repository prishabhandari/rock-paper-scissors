import java.util.*;

/**
 * Implements a strategic Player for Rock-Paper-Scissors
 */
public class StrategicPlayer implements Player {
    private static String name = "StrategicBot";
    private Random random = new Random();

    public String move(String[] myMoves, String[] opponentMoves, int myScore, int opponentScore) {
        // First move: start with rock
        if (myMoves.length == 0) {
            return "r";
        }

        // Count occurrences of opponent's moves
        int rockCount = 0, paperCount = 0, scissorsCount = 0;
        for (String move : opponentMoves) {
            if (move != null) {
                switch (move) {
                    case "r": rockCount++; break;
                    case "p": paperCount++; break;
                    case "s": scissorsCount++; break;
                }
            }
        }

        // Predict opponent's next move based on their most frequent move
        String predictedMove;
        if (rockCount >= paperCount && rockCount >= scissorsCount) {
            predictedMove = "r";
        } else if (paperCount >= rockCount && paperCount >= scissorsCount) {
            predictedMove = "p";
        } else {
            predictedMove = "s";
        }

        // Counter the predicted move
        String counterMove;
        switch (predictedMove) {
            case "r": counterMove = "p"; break;
            case "p": counterMove = "s"; break;
            default: counterMove = "r"; break;
        }

        // Introduce randomness: one-third of the time, pick a random move
        if (random.nextInt(3) == 0) {
            String[] moves = {"r", "p", "s"};
            return moves[random.nextInt(3)];
        }

        return counterMove;
    }

    public String getName() {
        return name;
    }
}

