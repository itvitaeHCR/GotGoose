import java.util.Random;

/**
 *
 */
public class Dice {

    public static void setLastThrow(int lastThrow) {
        Dice.lastThrow = lastThrow;
    }

    static int lastThrow;

    /**
     * calls throw() twice, saving each value separately and combining them into the total sum. This value is stored in lastThrow until the next time the function is called.
     * @return totalThrow
     */
    public static int lastThrow() {
        int throw1 = Throw();          // generate throw
        int throw2 = Throw();          // generate *separate* throw
        int totalThrow = throw1 + throw2;
        setLastThrow(totalThrow);
        return totalThrow;

    }

    /**
     * simulates a throw of a die by generating a random number between 1 and 6
     * @return throw
     */
    public static int Throw() {
        Random die = new Random();
        return (die.nextInt(6)) +1;
    }
}

