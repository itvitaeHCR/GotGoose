// LEFT OFF AT GAME > SWITCH > INIT ORDERS

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // during WIP phase: check if works
            // Dice.java
//        System.out.println(Dice.lastRoll());   // 2 dice, full throw
//        System.out.println(Dice.Roll());       // 1 die, init throw
            // Board.java
        Board board = new Board();
        Board.printBoard();                     // plain board printed
        Board.printBoardId();
            // Game
        Game.startGame();
        Board.printBoard();
            // Player
        System.out.println();
    }
}

/** init phase
 * generate new player
 * set player color
 * set player initiative order
 * set player location to 0
 */

/** game phase 1
 * select current player
 * check if bool skipTurn = false (if true, skip following steps)
 */

/** game phase 2
 * current player rolls dice
 */

/** game phase 3
 * player moves
 * board checks on location for special actions
 * IF special action: execute special action
 * end turn, call phase 1 for next player
 */