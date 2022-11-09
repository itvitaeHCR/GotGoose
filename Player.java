import java.util.ArrayList;
import java.util.Collections;

public class Player {

    static ArrayList<Player> players = new ArrayList<>();
    enum Colors {RED, YELLOW, GREEN, BLUE, PURPLE, CYAN}

    public String color;
    public float initOrder;



    static int[] locations = new int[6];                                            // redundant: remove when possible
    public int location;

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
    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }




    Player(String iColor) {
        this.color = iColor;
        location = 0;
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
        int pickColor = Main.scanner.nextInt();
        switch (pickColor) {
            case 1 -> genPlayer("RED");
            case 2 -> genPlayer("YELLOW");
            case 3 -> genPlayer("GREEN");
            case 4 -> genPlayer("BLUE");
            case 5 -> genPlayer("PURPLE");
            case 6 -> genPlayer("CYAN");
            default -> {
                System.out.println("Please cooperate.");
                playerSetUp();
            }
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
        System.out.println();
    }

}


/**
 * sets text color or text background to player color.
 * adjusted from <a href="https://stackoverflow.com/a/45444716">Stackoverflow ConsoleColor</a>
 */
class ConColor {

    public static void resetConColor() {
        System.out.print("\033[0m");
    }

    public static void textConColor(String iColor) {
        switch (iColor) {
            case "RED" -> System.out.print("\033[0;31m");
            case "YELLOW" -> System.out.print("\033[0;32m");
            case "GREEN" -> System.out.print("\033[0;33m");
            case "BLUE" -> System.out.print("\033[0;34m");
            case "PURPLE" -> System.out.print("\033[0;35m");
            case "CYAN" -> System.out.print("\033[0;36m");
        }
    }

    public static void backConColor(String iColor) {
        switch (iColor) {
            case "RED" -> System.out.print("\033[0;41m");
            case "YELLOW" -> System.out.print("\033[0;42m");
            case "GREEN" -> System.out.print("\033[0;43m");
            case "BLUE" -> System.out.print("\033[0;44m");
            case "PURPLE" -> System.out.print("\033[0;45m");
            case "CYAN" -> System.out.print("\033[0;46m");
        }
    }


    // Background
    public static final String RED_BACK = "\033[41m";    // RED
    public static final String GREEN_BACK = "\033[42m";  // GREEN
    public static final String YELLOW_BACK = "\033[43m"; // YELLOW
    public static final String BLUE_BACK = "\033[44m";   // BLUE
    public static final String PURPLE_BACK = "\033[45m"; // PURPLE
    public static final String CYAN_BACK = "\033[46m";   // CYAN
}
