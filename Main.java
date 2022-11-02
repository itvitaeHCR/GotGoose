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
        //board.printBoard();                     // plain board printed
        //board.printBoardId();
            // Game
        Game.startGame();
        board.printBoard();
            // Player
        System.out.println();

    }
}