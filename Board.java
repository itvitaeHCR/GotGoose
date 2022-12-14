public class Board {
    static Panel[] panels = new Panel[64];

    /**
     * The Board() constructor creates the game board by generating each panel as a default or special subclass.
     */
    Board() {
        for (int i = 0; i < panels.length; i++) {
            switch (i) {
                case 0 -> panels[i] = new StartPanel((byte)(i));
                case 6 -> panels[i] = new BridgePanel((byte)(i));
                case 19 -> panels[i] = new InnPanel((byte)(i));
                case 31 -> panels[i] = new WellPanel((byte)(i));
                case 42 -> panels[i] = new ThornPanel((byte)(i));
                case 52 -> panels[i] = new PrisonPanel((byte)(i));
                case 58 -> panels[i] = new DeathPanel((byte)(i));
                case 63 -> panels[i] = new FinishPanel((byte)(i));
                case 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59 -> panels[i] = new GoosePanel((byte)(i));
                default -> panels[i] = new Panel((byte)(i));
            }
        }
    }

    /**
     * printBoard() prints the game board by printing specific characters for default and special panels,
     * including pawn positions.
     */
    public static void printBoard() {
        System.out.println();
        System.out.println("=".repeat(panels.length * 3 + 6));
        for (int r = 0; r < Player.players.size(); r++) {       // for each player-index
            int loc = Player.players.get(r).getLocation();      // loc = location of player at index

            for (Panel x : panels) {
                if (x.id == 0) {
                    if (x.id == loc) {
                        printPanelZero(r);
                    }
                } else if (x.id > 0) {
                    if (x.id == loc) {
                        printPlayerPanel(r, x);
                    }
                } else {
                    System.out.print(x.panelImage);
                }
            }


//                if (x.id == loc) {
//                    if (x.id == 0) {
//                        printPanelZero(r);
//                    } else if (x.id > 0) {
//                        printPlayerPanel(r, x);
//                    }
//                } else {
//                    System.out.print(x.panelImage);
//                }



//            if (loc == 0) {                                 // AND if loc equals zero
//                printPanelZero(r);                              // print a zero-panel for each player on zero
//            } else if (loc > 0){
//                for (Panel x : panels) {                            // for each Panel
//                    if (x.id == loc) {                              // if loc is equal to panel id
//                        if (loc != 0) {                                        // if loc NOT equal to zero BUT equal to panel id
//                            printPlayerPanel(r, x);                         // print player-colored panel
//                        } else {                                        // if panel id equals no loc
//                            System.out.print(x.panelImage);                 // print non-color panel image
//                        }
//                    }
//                }
//            }
//        }
            System.out.println();
            System.out.println("=".repeat(panels.length * 3 + 6));
            System.out.println();
        }
    }

//            if (x.id > 0) {                                                // prints each loc (opt. with Player)
//                if (x.id == Player.locations[0]) {
//                    System.out.print(ConColor.RED_BACK + "[" + x.panelImage + "]");
//                } else if (x.id == Player.locations[1]) {
//                    System.out.print(ConColor.YELLOW_BACK + "[" + x.panelImage + "]");
//                } else if (x.id == Player.locations[2]) {
//                    System.out.print(ConColor.GREEN_BACK + "[" + x.panelImage + "]");
//                } else if (x.id == Player.locations[3]) {
//                    System.out.print(ConColor.BLUE_BACK + "[" + x.panelImage + "]");
//                } else if (x.id == Player.locations[4]) {
//                    System.out.print(ConColor.PURPLE_BACK + "[" + x.panelImage + "]");
//                } else if (x.id == Player.locations[5]) {
//                    System.out.print(ConColor.CYAN_BACK + "[" + x.panelImage + "]");
//                } else {
//                    ConColor.resetConColor();
//                    System.out.print(x.panelImage);
//                }




    private static void printPlayerPanel(int r, Panel x) {
        String y = Player.players.get(r).color;
        ConColor.backConColor(y);
        System.out.print(x.panelImage);
        ConColor.resetConColor();
    }

    private static void printPanelZero(int r) {
        String y = Player.players.get(r).color;
        ConColor.backConColor(y);
        System.out.print("[ * ] ");
        ConColor.resetConColor();
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
    public void printPanel() {                                                          // SIMPLIFY PRINTBOARD!!!!!!
        // code here
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
        int walk = Dice.lastRoll;                                                                               // ???
        setPanelImage();
    }
    @Override
    public void setPanelImage() {
        panelImage = " @ ";
    }
}

class StartPanel extends SpecPanel {
    StartPanel(byte id) {
        super(id);
        setPanelImage();
        // for each player print [ p ] with background color
    }
}

class FinishPanel extends SpecPanel {
    FinishPanel(byte id) {
        super(id);
        setPanelImage();
    }
}

class DeathPanel extends SpecPanel {
    DeathPanel(byte id) {
        super(id);
        setPanelImage();
    }
}

class BridgePanel extends SpecPanel {
    BridgePanel(byte id) {
        super(id);
        setPanelImage();
    }
}

class InnPanel extends SpecPanel {
    InnPanel(byte id) {
        super(id);
        setPanelImage();
    }
}

class WellPanel extends SpecPanel {
    WellPanel(byte id) {
        super(id);
        setPanelImage();
    }
}

class ThornPanel extends SpecPanel {
    ThornPanel(byte id) {
        super(id);
        setPanelImage();
    }
}

class PrisonPanel extends SpecPanel {
    PrisonPanel(byte id) {
        super(id);
        setPanelImage();
    }
}



//        brug > lopen naar x, mag geen gans op blijven staan
//        herberg >
//        put >
//        gevangenis >
//        doornstruik >








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