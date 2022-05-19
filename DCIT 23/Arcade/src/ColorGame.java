import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ColorGame {
    private String[] choice= {"RED", "BLUE", "YELLOW", "WHITE"};
    private int round = 0;
    private int ticket = 0;

    // Instantiating Class
    ColorGame() {
        System.out.println("\n########################################################################################################");
        System.out.println("# WELCOME TO COLOR GAME!                                                                               #");
        System.out.println("# Description: You need to guess a color from RED, BLUE, YELLOW, and WHITE. You have 5 attempts!       #");
        System.out.println("# Prizes:                                                                                              #");
        System.out.println("# If guess is correct you will win 5 tickets!                                                          #");
        System.out.println("# If guess is incorrect you will win 1 tickets!                                                        #");
        System.out.println("########################################################################################################\n");

        System.out.println("--- GAME HAS BEEN STARTED! ---");
    }

    // Start the Color Game
    public void startColorGame() {
        Scanner inGuessNumber = new Scanner(System.in);
        
        while(round < 5) {
            System.out.print("\n########################################################################################################\n");
            System.out.print("\nGuess a color (RED, BLUE, YELLOW, WHITE): ");
            String playerColor = inGuessNumber.nextLine().toUpperCase();
            String randomColors = randomColors();

            while(!Pattern.compile("^(RED|BLUE|YELLOW|WHITE)$").matcher(playerColor).find()) {
                System.out.println("Your guess is invalid!\n");
                System.out.print("\nGuess a color (RED, BLUE, YELLOW, WHITE): ");
                playerColor = inGuessNumber.nextLine().toUpperCase();
            }

            if(playerColor.equals(randomColors)) {
                ticket += 1;
                System.out.println("Random Color: " + randomColors);
                System.out.println("Result: Your color guess is correct!");
            } else {
                System.out.println("Random Color: " + randomColors);
                System.out.println("Result: Your color guess is incorrect!");
            }

            round++;
        }
    }

    // Get Random Colors
    public String randomColors() {
        Random random = new Random();
        String result = choice[random.nextInt(4)];
        return result;
    }

    // Get tickets won
    public int getTicket() {
        return ticket *= 5;
    }
}
