public class Game {
    static int players;



    /**
     * startGame() encompasses the setup phase of a game. It asks for a number of players and makes all necessary
     * preparations by calling initiative(), which in turn calls pickPlayer().
     */
    public static void startGame() {
        System.out.print("How many players does your game have?\t:\t");
        players = Main.scanner.nextInt();
        initiative();
        Player.initSort();
    }

    /**
     * initiative() loops through given number of players and calls pickPlayer() for each player.
     */
    public static void initiative() {
        System.out.println("Please each throw a die to set up initiative order by picking a pawn color from the list. "
                + "Each color can be chosen once.");
        for (int i = 0; i < players; i++) {
            pickPlayer();
        }
    }

    /**
     * pickPlayer() has each Player instance pick a color, assigns a corresponding id,
     * and generates an initiative order value.
     */
    public static void pickPlayer() {
        Player.playerSetUp();

    }
}
