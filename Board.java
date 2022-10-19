public class Board {
    static Panel[] panels = new Panel[64];

    /**
     * The Board() constructor creates the game board by generating each panel as a default or special subclass.
     */
    Board() {
        for (int i = 0; i < panels.length; i++) {
            switch (i) {
                case 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59 -> panels[i] = new GoosePanel((byte)(i));
                case 0, 6, 19, 31, 42, 52, 58, 63 -> panels[i] = new SpecPanel((byte)(i));
                default -> panels[i] = new Panel((byte)(i));
            }
        }
    }

    /**
     * printBoard() prints the game board by printing specific characters for default and special panels.
     */
    public static void printBoard() {
        for (int i = 0; i < panels.length; i++) {
            switch (i) {
            case 6, 19, 31, 42, 52, 58 -> System.out.print("x  ");
            case 0, 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59, 63 -> System.out.print("@  ");
            default -> System.out.print("O  ");
            }
        }
        System.out.println();
    }

}

/**
 * Basic panels on the board are assigned an id, and checks if the panel is already taken by another player.
 */
class Panel {
    byte id;
    boolean taken;

    Panel(byte id) {
        this.id = id;
    }
}

/**
 * A SpecPanel is a collection of special Panels, each having their own non-default effect on the player.
 */
class SpecPanel extends Panel { // 0, 6 | 19 | 31 | 42 | 52 | 58, 63

    SpecPanel(byte id) {
        super(id);
    }
}

/**
 * A Goosepanel will take the Dice.lastThrow() value of the player that lands on it,
 * and send the player further that amount of panels.
 */
class GoosePanel extends SpecPanel { // 5 | 9 | 14 | 18 | 23 | 27 | 32 | 36 | 41 | 45 | 50 | 54 | 59
    GoosePanel(byte id) {
        super(id);
        int walk = Dice.lastRoll;
    }
}


// lol ganzenbord magie xor 63
//    Board() {
//        for (int i = 0; i < 64; i++) {
//            switch (i) {
//                case 5 | 9 | 14 | 18 | 23 | 27 | 32 | 36 | 41 | 45 | 50 | 54 | 59:
//                    panels[i] = new GoosePanel((byte) (i));
//                    break;
//                case 6 | 19 | 31 | 42 | 52 | 58:
//                    panels[i] = new SpecPanel((byte) (i));
//                    break;
//                default:
//                    panels[i] = new Panel((byte) (i));
//            }
//        }
//    }