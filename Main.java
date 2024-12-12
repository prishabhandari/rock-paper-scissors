import java.util.*;

/**
 * Driver class, sets up game
 * Look to comments to see what you need to do to test your game
 */
public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[2];  // Adjust array size based on the number of players
        boolean printsRun = false;   // Enable/disable debug print statements.

        // Add players to the game
        players[0] = new Example1();  // Replace Example1 with your first player class
        players[1] = new StrategicPlayer(); // Add the StrategicPlayer

        // Construct the game with the classes in the players array, calls on play, and displays the score
        Game newGame = new Game(players, printsRun);
        newGame.play();
        newGame.displayScore();
    }
}
