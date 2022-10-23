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
        System.out.println();
        System.out.println("=".repeat(panels.length*3 + 6));
        for (Panel x : panels) {
            if (x.id > 0) {
                if (x.id == Player.locations[0]) {
                    System.out.print(Player.ConColor.RED_BACK + "[" + x.panelImage + "]" + Player.ConColor.RESET);
                } else if (x.id == Player.locations[1]) {
                    System.out.print(Player.ConColor.YELLOW_BACK + "[" + x.panelImage + "]" + Player.ConColor.RESET);
                } else if (x.id == Player.locations[2]) {
                    System.out.print(Player.ConColor.GREEN_BACK + "[" + x.panelImage + "]" + Player.ConColor.RESET);
                } else if (x.id == Player.locations[3]) {
                    System.out.print(Player.ConColor.BLUE_BACK + "[" + x.panelImage + "]" + Player.ConColor.RESET);
                } else if (x.id == Player.locations[4]) {
                    System.out.print(Player.ConColor.PURPLE_BACK + "[" + x.panelImage + "]" + Player.ConColor.RESET);
                } else if (x.id == Player.locations[5]) {
                    System.out.print(Player.ConColor.CYAN_BACK + "[" + x.panelImage + "]" + Player.ConColor.RESET);
                } else {
                    System.out.print(x.panelImage);
                }
            } else {
                System.out.print(x.panelImage);
            }
        }
        System.out.println();
        System.out.println("=".repeat(panels.length*3 + 6));
        System.out.println();
    }
    public static void printBoardId() {
        for (Panel x : panels) {
            System.out.print(x.id + " ");
        }
        System.out.println();
    }

}

/**
 * Basic panels on the board are assigned an id, and checks if the panel is already taken by another player.
 */
class Panel {

    public String panelImage;
    byte id;
    boolean taken;

    Panel(byte id) {
        this.id = id;
        setPanelImage();
        }
    public void setPanelImage() {
        panelImage = " O ";
    }
}

/**
 * A SpecPanel is a collection of special Panels, each having their own non-default effect on the player.
 */
class SpecPanel extends Panel { // 0, 6 | 19 | 31 | 42 | 52 | 58, 63

    SpecPanel(byte id) {
        super(id);
        setPanelImage();
    }
    @Override
    public void setPanelImage() {
        panelImage = " X ";
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
        setPanelImage();
    }
    @Override
    public void setPanelImage() {
        panelImage = " @ ";
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