import java.util.Random;

/**
 *
 */
public class Dice {

    public static void setLastRoll(int lastRoll) {
        Dice.lastRoll = lastRoll;
    }
    static Random die = new Random();
    static int lastRoll;


    /**
     * calls roll() twice, saving each value separately and combining them into the total sum.
     * This value is stored in lastThrow until the next time the function is called.
     * @return totalThrow
     */
    public static int lastRoll() {
        int roll1 = (int)Roll();          // generate throw
        int roll2 = (int)Roll();          // generate *separate* throw
        int totalRoll = roll1 + roll2;
        setLastRoll(totalRoll);
        return totalRoll;

    }

    /**
     * simulates a throw of a die by generating a random number between 1 and 6
     * @return roll
     */
    public static float Roll() {                                            // currently float for initiative purposes
        return die.nextFloat(6) +1;
    }

    public static void checkFirstRoll() {
        // if 4+5 > go to x
        // if 3+6 > go to y
    }
}

