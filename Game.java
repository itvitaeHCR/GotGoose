import java.util.Scanner;

public class Game {
    static int players;
    public static void startGame() {
        Scanner game = new Scanner(System.in);
        System.out.print("How many players does your game have?\t:\t");
        players = game.nextInt();
        System.out.println(players);
    }
}
