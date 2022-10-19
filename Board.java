public class Board {
    static Panel[] panels = new Panel[64];


    Board() {
        for (int i = 0; i < 64; i++) {
            switch (i) {
                case 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59 -> panels[i] = new GoosePanel((byte)(i));
                case 6, 19, 31, 42, 52, 58 -> panels[i] = new SpecPanel((byte)(i));
                default -> panels[i] = new Panel((byte)(i));
            }
        }
    }

    public static void printBoard() { // getClass = null??
        for (int i = 0; i < panels.length; i++) {
            if (panels[i].getClass() == SpecPanel.class) {
                System.out.println("x  ");
            } else if (panels[i].getClass() == GoosePanel.class) {
                System.out.println("@  ");
            } else {
                System.out.println("O  ");
            }
        }
    }

}


class Panel {
    byte id;
    boolean taken;

    Panel(byte id) {
        this.id = id;
    }
}

class SpecPanel extends Panel { // 6 | 19 | 31 | 42 | 52 | 58

    SpecPanel(byte id) {
        super(id);
    }
}

class GoosePanel extends SpecPanel { // 5 | 9 | 14 | 18 | 23 | 27 | 32 | 36 | 41 | 45 | 50 | 54 | 59
    GoosePanel(byte id) {
        super(id);
        int walk = Dice.lastThrow();
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