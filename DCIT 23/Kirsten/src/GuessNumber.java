import java.util.*;

public class GuessNumber {
    private int score = 0;
    private int guessNumberRound = 1;

    GuessNumber() {
        System.out.println("\n");
        System.out.println("GAME STARTED!");
        System.out.println("Information: You need to guess a number from 1 to 3 for 3 rounds!");
        System.out.println("Prizes:");
        System.out.println("If your guess is correct then you'll receive 3 tickets.");
        System.out.println("\n");
    }

    public void startGuessNumber() {
        Scanner sc = new Scanner(System.in);
        
        while(guessNumberRound <= 3) {
            System.out.print("\nGuess the number (1-3): ");
            String playerGuess = sc.nextLine();
            String randomNumber = randomNumbers();

            if(playerGuess.equals(randomNumber)) {
                System.out.println("Random Number (1-3): " + randomNumber);
                System.out.println("Result: Your input matched!");
                score += 1;
            } else {
                System.out.println("Random Number: " + randomNumber);
                System.out.println("Result: Your input didn't matched!");
            }

            guessNumberRound++;
        }
    }

    public String randomNumbers() {
        Random random = new Random();
        return String.valueOf(random.nextInt(3)+1);
    }

    public int getTicket() {
        return score *= 3;
    }
}
