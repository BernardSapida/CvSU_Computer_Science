import java.util.Random;

public class ComputeMethods {

    public double hypotenuse(int a, int b) {
        return Math.hypot(a, b);
    }

    public int roll() {
        Random rand = new Random();
        int dice1 = rand.nextInt(6)+1;
        int dice2 = rand.nextInt(6)+1;
        int multiplier  = rand.nextInt(6)+1;

        System.out.println("\n\nDice 1: " + dice1);
        System.out.println("Dice 2: " + dice2);
        System.out.println("Multiplier: " + multiplier);

        return (dice1 + dice2) * multiplier;
    }
}