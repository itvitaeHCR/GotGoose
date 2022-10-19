import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // omg dice is working whatt
        System.out.println(Dice.lastThrow());   // 2 dice, full throw
        System.out.println(Dice.Throw());       // 1 die, init throw
        Board.printBoard();
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