import java.util.Random;
public class Dice {
    int lastThrow;

    public int getLastThrow() {
        return lastThrow;
    }


    public static int lastThrow() {
        // generate random throw 1
        int throw1 = Throw ();
        // generate random throw 2
        int throw2 = Throw ();
        int totalThrow = throw1 + throw2;
        return totalThrow;
    }

    public static int Throw() {
        Random die = new Random();
        int i = (die.nextInt(6)) +1;
        return i;
    }
}

