import java.util.*;
import java.util.regex.Pattern;

public class GuessNumber {
    private int scorePlayer = 0;
    private int round = 1;

    // Instantiating Class
    GuessNumber() {
        System.out.println("\n########################################################################################################");
        System.out.println("# WELCOME TO GUESS NUMBER!                                                                             #");
        System.out.println("# Description: You need to guess a number from 1 to 5, you have 5 rounds!                              #");
        System.out.println("# Prizes:                                                                                              #");
        System.out.println("# If you guess correct number you'll win 5 tickets each rounds.                                        #");
        System.out.println("########################################################################################################\n");
        System.out.println("--- GAME HAS BEEN STARTED! ---");
    }

    // Start the Guess Number Game
    public void startGuessNumber() {
        Scanner in = new Scanner(System.in);
        
        while(round <= 5) {
            System.out.print("\n########################################################################################################\n");
            System.out.print("\nGuess a number (1-5): ");
            String playerGuess = in.nextLine();
            String randomNumber = randomNumbers();

            while(!Pattern.compile("^(1|2|3|4|5)$").matcher(playerGuess).find()) {
                System.out.println("Your guess is invalid!\n");
                System.out.print("Guess a number (1-5): ");
                playerGuess = in.nextLine();
            }

            if(playerGuess.equals(randomNumber)) {
                scorePlayer += 1;
                System.out.println("Random Number: " + randomNumber);
                System.out.println("Result: Your guess is correct!");
            } else {
                System.out.println("Random Number: " + randomNumber);
                System.out.println("Result: Your guess is incorrect!");
            }

            round++;
        }
    }

    // Get Random Numbers
    public String randomNumbers() {
        Random random = new Random();
        String result = String.valueOf(random.nextInt(5)+1);
        return result;
    }

    // Get tickets won
    public int getTicket() {
        return scorePlayer *= 5;
    }
}
