import java.util.Scanner;

public class Game {
    static int players;
    public static void startGame() {
        Scanner game = new Scanner(System.in);
        System.out.print("How many players does your game have?\t:\t");
        players = game.nextInt();
        initiative();
    }

    public static void initiative() {
        System.out.println("You have " + players + " in your game.\n Please each throw a die to set up initiative order by picking a pawn color from the list. Each color can be chosen once.");
        for (int i = 0; i < players;i++) {
            System.out.println("1 player");
            pickPlayer();
            // method
        }

    }

    public static void pickPlayer() {
        System.out.println("Pick a color! Your options are: " + ConColor.RED + "\n\t1: RED;" + ConColor.GREEN + "\n\t2: GREEN;"
                + ConColor.YELLOW + "\n\t3: YELLOW;" + ConColor.BLUE + "\n\t4: BLUE;" + ConColor.PURPLE + "\n\t5: PURPLE;" + ConColor.CYAN + "\n\t6: CYAN.");


    }

}
