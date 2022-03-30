import java.util.Random;
import java.lang.Math;

public class ComputeMethods {
    // Class Fields
    public int dice_1, dice_2, multiplier, result;

    // hypotenuse method will return the calculated hypotenuse
    public double hypotenuse(int a, int b) {
        System.out.println("\nOutput:");
        System.out.println("a=" + a + ", b=" + b + " (User Input)");
        return Math.hypot(a, b);
    }

    // roll method will return the dice roll result
    public int roll() {
        // Instantiating Random Class
        Random diceNumber = new Random();

        // Output Header
        System.out.println("\n\n=======================\n||    DICE RESULT    ||\n=======================");

        // Getting random result from dice
        dice_1 = diceNumber.nextInt(6)+1;
        System.out.println("Dice 1: " + dice_1);
        dice_2 = diceNumber.nextInt(6)+1;
        System.out.println("Dice 2: " + dice_2);
        multiplier = diceNumber.nextInt(6)+1;
        System.out.println("Multiplier: " + multiplier);

        // Dice Roll Result
        result = (dice_1+dice_2)*multiplier;

        return result;
    }
}