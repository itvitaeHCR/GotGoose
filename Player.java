public class Player {


    public static Player[] players = new Player[6];
    public String color;
    public float initOrder;
    static int[] locations = new int[6];
    static int location = 0;

    Player(String color) {
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
                players[0] = RED;
                System.out.println(ConColor.RED + "Welcome player RED");
                RED.initOrder = Dice.Roll();
                Dice.firstRolls[0] = RED.initOrder;
                System.out.println("Your initiative order roll is " + (int) RED.initOrder);
                System.out.println("Your tie-breaker modifier is " + (RED.initOrder - (int) (RED.initOrder)));
                System.out.println(ConColor.RESET);
                break;
            case 2:
                Player YELLOW = new Player("YELLOW");
                players[1] = YELLOW;
                System.out.println(ConColor.YELLOW + "Welcome player YELLOW");
                System.out.println();
                YELLOW.initOrder = Dice.Roll();
                Dice.firstRolls[1] = YELLOW.initOrder;
                System.out.println("Your initiative order roll is " + (int) YELLOW.initOrder);
                System.out.println("Your tie-breaker modifier is " + (YELLOW.initOrder - (int) (YELLOW.initOrder)));
                System.out.println(ConColor.RESET);
                break;
            case 3:
                Player GREEN = new Player("GREEN");
                players[2] = GREEN;
                System.out.println(ConColor.GREEN + "Welcome player GREEN");
                GREEN.initOrder = Dice.Roll();
                Dice.firstRolls[2] = GREEN.initOrder;
                System.out.println("Your initiative order roll is " + (int) GREEN.initOrder);
                System.out.println("Your tie-breaker modifier is " + (GREEN.initOrder - (int) (GREEN.initOrder)));
                System.out.println(ConColor.RESET);
                break;
            case 4:
                Player BLUE = new Player("BLUE");
                players[3] = BLUE;
                System.out.println(ConColor.BLUE + "Welcome player BLUE");
                BLUE.initOrder = Dice.Roll();
                Dice.firstRolls[3] = BLUE.initOrder;
                System.out.println("Your initiative order roll is " + (int) BLUE.initOrder);
                System.out.println("Your tie-breaker modifier is " + (BLUE.initOrder - (int) (BLUE.initOrder)));
                System.out.println(ConColor.RESET);
                break;
            case 5:
                Player PURPLE = new Player("PURPLE");
                players[4] = PURPLE;
                System.out.println(ConColor.PURPLE + "Welcome player PURPLE");
                PURPLE.initOrder = Dice.Roll();
                Dice.firstRolls[4] = PURPLE.initOrder;
                System.out.println("Your initiative order roll is " + (int) PURPLE.initOrder);
                System.out.println("Your tie-breaker modifier is " + (PURPLE.initOrder - (int) (PURPLE.initOrder)));
                System.out.println(ConColor.RESET);
                break;
            case 6:
                Player CYAN = new Player("CYAN");
                players[5] = CYAN;
                System.out.println(ConColor.CYAN + "Welcome player CYAN");
                CYAN.initOrder = Dice.Roll();
                Dice.firstRolls[5] = CYAN.initOrder;
                System.out.println("Your initiative order roll is " + (int) CYAN.initOrder);
                System.out.println("Your tie-breaker modifier is " + (CYAN.initOrder - (int) (CYAN.initOrder)));
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