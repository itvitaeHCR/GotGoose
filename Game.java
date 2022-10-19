import java.util.Scanner;

public class Game {
    static int players;

    /**
     * startGame() encompasses the setup phase of a game. It asks for a number of players and makes all necessary preparations by calling initiative(), which in turn calls pickPlayer().
     */
    public static void startGame() {
        Scanner game = new Scanner(System.in);
        System.out.print("How many players does your game have?\t:\t");
        players = game.nextInt();
        initiative();
    }

    /**
     * initiative() loops through given number of players and calls pickPlayer() for each player.
     */
    public static void initiative() {
        System.out.println("You have " + players + " in your game.\n Please each throw a die to set up initiative order by picking a pawn color from the list. Each color can be chosen once.");
        for (int i = 0; i < players; i++) {
            System.out.println("1 player");
            pickPlayer();
            // method
        }

    }

    /**
     * pickPlayer() has each Player instance pick a color, assigns a corresponding id, and generates an initiative order value.
     */
    public static void pickPlayer() {
        Scanner player = new Scanner(System.in);
        System.out.println("Pick a color! Your options are: "
                + ConColor.RED + "\n\t1: RED;" + ConColor.GREEN + "\n\t2: GREEN;" + ConColor.YELLOW + "\n\t3: YELLOW;"
                + ConColor.BLUE + "\n\t4: BLUE;" + ConColor.PURPLE + "\n\t5: PURPLE;" + ConColor.CYAN + "\n\t6: CYAN."
                + ConColor.RESET + "\nYour choice:\t");
        int pickColor = player.nextInt();
        switch (pickColor) {
            case 1:
                Player RED = new Player("RED");
                break;
            case 2:
                Player GREEN = new Player("GREEN");
                break;
            case 3:
                Player YELLOW = new Player("YELLOW");
                break;
            case 4:
                Player BLUE = new Player("BLUE");
                break;
            case 5:
                Player PURPLE = new Player("PURPLE");
                break;
            case 6:
                Player CYAN = new Player("CYAN");
                break;
        }

    }

}
