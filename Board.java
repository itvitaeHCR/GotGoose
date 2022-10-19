public class Board {
    static Panel[] panels = new Panel[64];


    Board() {
        for (int i = 0; i < panels.length; i++) {
            switch (i) {
                case 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59 -> panels[i] = new GoosePanel((byte)(i));
                case 0, 6, 19, 31, 42, 52, 58, 63 -> panels[i] = new SpecPanel((byte)(i));
                default -> panels[i] = new Panel((byte)(i));
            }
        }
    }

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


class Panel {
    byte id;
    boolean taken;

    Panel(byte id) {
        this.id = id;
    }
}

class SpecPanel extends Panel { // 0, 6 | 19 | 31 | 42 | 52 | 58, 63

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