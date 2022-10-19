import java.util.Random;

/**
 *
 */
public class Dice {

    public static void setLastRoll(int lastRoll) {
        Dice.lastRoll = lastRoll;
    }

    static int lastRoll;

    /**
     * calls roll() twice, saving each value separately and combining them into the total sum.
     * This value is stored in lastThrow until the next time the function is called.
     * @return totalThrow
     */
    public static int lastRoll() {
        int roll1 = Roll();          // generate throw
        int roll2 = Roll();          // generate *separate* throw
        int totalRoll = roll1 + roll2;
        setLastRoll(totalRoll);
        return totalRoll;

    }

    /**
     * simulates a throw of a die by generating a random number between 1 and 6
     * @return throw
     */
    public static int Roll() {
        Random die = new Random();
        return (die.nextInt(6)) +1;
    }
}

