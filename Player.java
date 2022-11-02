import java.util.ArrayList;
import java.util.Collections;

public class Player {

    static ArrayList<Player> players = new ArrayList<>();
    public String color;
    public float initOrder;
    static int[] locations = new int[6];                                            // redundant: remove when possible
    static int location = 0;

    // getters and setters
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public float getInitOrder() {
        return initOrder;
    }
    public void setInitOrder(float initOrder) {
        this.initOrder = initOrder;
    }
    public static int getLocation() {
        return location;
    }
    public static void setLocation(int location) {
        Player.location = location;
    }



    Player(String iColor) {
        this.color = iColor;
        boolean won;

    }
    public static Player getPlayer(String iColor) {
        for (Player p : players) {
            if (p.getColor().equals(iColor)) {
                return p;
            }
        } return null;                                                                          // throw exception evt
    }

    public static void playerSetUp() {
        System.out.println("Pick a color! Your options are: "
                + ConColor.RED + "\t\t1: RED" + ConColor.YELLOW + "\t\t2: YELLOW" + ConColor.GREEN + "\t\t3: GREEN"
                + ConColor.BLUE + "\t\t4: BLUE" + ConColor.PURPLE + "\t\t5: PURPLE" + ConColor.CYAN + "\t\t6: CYAN"
                + ConColor.RESET + "\nYour choice:\t");
        int pickColor = Main.scanner.nextInt();
        switch (pickColor) {
            case 1:
                genPlayer("RED");
                break;
            case 2:
                genPlayer("YELLOW");
                break;
            case 3:
                genPlayer("GREEN");
                break;
            case 4:
                genPlayer("BLUE");
                break;
            case 5:
                genPlayer("PURPLE");
                break;
            case 6:
                genPlayer("CYAN");
                break;
            default:
                System.out.println("Please cooperate.");
                playerSetUp();
        }
    }

    /**
     * sorts the ArrayList pawns in descending order of initiative roll.
     * adapted from tutorial <a href="https://www.youtube.com/watch?v=wzWFQTLn8hI">"Sort ArrayList of Objects"</a>
     */
    public static void initSort() {
        Collections.sort(players, (o1, o2) -> Float.valueOf(o2.initOrder).compareTo(o1.initOrder));
//        for(int i = 0; i < players.size(); i++) {
//            System.out.println("Player " + players.get(i).color + " rolled initiative " + players.get(i).initOrder);
//        }
    }

    public static void genPlayer(String iColor) {
        ConColor.textConColor(iColor);
        players.add(new Player(iColor));
        Player.getPlayer(iColor).initOrder = Dice.Roll();
        System.out.println("Welcome player " + iColor +
                "! Your initiative order roll is " + (int) Player.getPlayer(iColor).initOrder +
                " with a modifier of " + (Player.getPlayer(iColor).initOrder - (int) (Player.getPlayer(iColor).initOrder)));
        ConColor.resetConColor();
    }

}


/**
 * sets text color or text background to player color.
 * adjusted from <a href="https://stackoverflow.com/a/45444716">Stackoverflow ConsoleColor</a>
 */
class ConColor {

    public static void resetConColor() {
        System.out.println("\033[0m");
    }

    public static void textConColor(String iColor) {
        switch (iColor) {
            case "RED" -> System.out.println("\033[0;31m");
            case "YELLOW" -> System.out.println("\033[0;32m");
            case "GREEN" -> System.out.println("\033[0;33m");
            case "BLUE" -> System.out.println("\033[0;34m");
            case "PURPLE" -> System.out.println("\033[0;35m");
            case "CYAN" -> System.out.println("\033[0;36m");
        }
    }

    public static void backConColor(String iColor) {
        switch (iColor) {
            case "RED" -> System.out.println("\033[0;41m");
            case "YELLOW" -> System.out.println("\033[0;42m");
            case "GREEN" -> System.out.println("\033[0;43m");
            case "BLUE" -> System.out.println("\033[0;44m");
            case "PURPLE" -> System.out.println("\033[0;45m");
            case "CYAN" -> System.out.println("\033[0;46m");
        }
    }

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Text
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN

    // Background
    public static final String RED_BACK = "\033[41m";    // RED
    public static final String GREEN_BACK = "\033[42m";  // GREEN
    public static final String YELLOW_BACK = "\033[43m"; // YELLOW
    public static final String BLUE_BACK = "\033[44m";   // BLUE
    public static final String PURPLE_BACK = "\033[45m"; // PURPLE
    public static final String CYAN_BACK = "\033[46m";   // CYAN
}

/**
 *         player-related values to be put in Panel
 *         boolean won = false;
 *         boolean skipTurn = false;
 */