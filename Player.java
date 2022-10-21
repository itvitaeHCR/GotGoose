import java.util.Scanner;

public class Player {


    public static String color;
    //private final int initOrder;
    public String Name;
    public byte initOrder;
    static int[] locations = new int[6];
    static int location = 0;

    Player(String color) {
        byte initOrder;
        this.color = color;
        boolean won;

    }


    public static void playerSetUp() {
        System.out.println("Pick a color! Your options are: "
                + ConColor.RED + "\t\t1: RED" + ConColor.YELLOW + "\t\t2: YELLOW" + ConColor.GREEN + "\t\t3: GREEN"
                + ConColor.BLUE + "\t\t4: BLUE" + ConColor.PURPLE + "\t\t5: PURPLE" + ConColor.CYAN + "\t\t6: CYAN"
                + ConColor.RESET + "\nYour choice:\t");
        int pickColor = Main.scanner.nextInt();
        switch (pickColor) {
            case 1:
                Player RED = new Player("RED");
                System.out.println(ConColor.RED + "Welcome player RED");
                RED.initOrder = (byte) Dice.Roll();
                Game.firstRolls[0] = RED.initOrder;
                locations[0] = RED.location; // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                System.out.println("Your initiative order roll is " + RED.initOrder);
                System.out.println(ConColor.RESET);
                break;
            case 2:
                Player YELLOW = new Player("YELLOW");
                System.out.println(ConColor.YELLOW + "Welcome player YELLOW");
                System.out.println();
                YELLOW.initOrder = (byte) Dice.Roll();
                Game.firstRolls[1] = YELLOW.initOrder;
                locations[1] = 2;//YELLOW.location; // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                System.out.println("Your initiative order roll is " + YELLOW.initOrder);
                System.out.println(ConColor.RESET);
                break;
            case 3:
                Player GREEN = new Player("GREEN");
                System.out.println(ConColor.GREEN + "Welcome player GREEN");
                GREEN.initOrder = (byte) Dice.Roll();
                Game.firstRolls[2] = GREEN.initOrder;
                locations[2] = 5; //GREEN.location; // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                System.out.println("Your initiative order roll is " + GREEN.initOrder);
                System.out.println(ConColor.RESET);
                break;
            case 4:
                Player BLUE = new Player("BLUE");
                System.out.println(ConColor.BLUE + "Welcome player BLUE");
                BLUE.initOrder = (byte) Dice.Roll();
                Game.firstRolls[3] = BLUE.initOrder;
                locations[3] = 23; //BLUE.location; // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                System.out.println("Your initiative order roll is " + BLUE.initOrder);
                System.out.println(ConColor.RESET);
                break;
            case 5:
                Player PURPLE = new Player("PURPLE");
                System.out.println(ConColor.PURPLE + "Welcome player PURPLE");
                PURPLE.initOrder = (byte) Dice.Roll();
                Game.firstRolls[4] = PURPLE.initOrder;
                locations[4] = 55; //PURPLE.location; // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                System.out.println("Your initiative order roll is " + PURPLE.initOrder);
                System.out.println(ConColor.RESET);
                break;
            case 6:
                Player CYAN = new Player("CYAN");
                System.out.println(ConColor.CYAN + "Welcome player CYAN");
                CYAN.initOrder = (byte) Dice.Roll();
                Game.firstRolls[5] = CYAN.initOrder;
                locations[5] = 43; //CYAN.location; // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                System.out.println("Your initiative order roll is " + CYAN.initOrder);
                System.out.println(ConColor.RESET);
                break;
            default:
                System.out.println("Please cooperate.");
                playerSetUp();
        }

    }


    class ConColor { // found on https://stackoverflow.com/a/45444716
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
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
}

/**
 *         player-related values to be put in Panel
 *         boolean won = false;
 *         boolean skipTurn = false;
 */