import java.util.*;
import java.util.regex.Pattern;

public class Rps {
    private int scorePlayer = 0;
    private int scoreComputer = 0;
    private String[] choice= {"ROCK", "PAPER", "SCISSOR"};
    private String winnerPlayer = "";

    // Instantiating Class
    Rps() {
        System.out.println("\n########################################################################################################");
        System.out.println("# WELCOME TO ROCK, PAPER, SCISSOR GAME!                                                                #");
        System.out.println("# Description: You need to win against the computer, the first player who reach 3points win the game!  #");
        System.out.println("# Prizes:                                                                                              #");
        System.out.println("# If you win: 10 tickets                                                                               #");
        System.out.println("# If you lose: 5 tickets                                                                               #");
        System.out.println("########################################################################################################\n");

        System.out.println("--- GAME HAS BEEN STARTED! ---");
    }

    // Start the RPS Game
    public void startRps() {
        Scanner in = new Scanner(System.in);
        
        while(winnerPlayer.equals("")) {
            String computerResponse = computerChoice();

            System.out.print("\n########################################################################################################\n");
            System.out.print("\nYour response (Rock, Paper, Scissor): ");
            String playerResponse = in.nextLine().toUpperCase();

            while(!Pattern.compile("^(ROCK|PAPER|SCISSOR)$").matcher(playerResponse).find()) {
                System.out.println("Your response is invalid!\n");
                System.out.print("Your response (Rock, Paper, Scissor): ");
                playerResponse = in.nextLine().toUpperCase();
            }

            System.out.println("You choose: " + playerResponse);
            System.out.println("Computer choose: " + computerResponse);
            getDecision(playerResponse, computerResponse);

            getWinner();
        }
    }

    // Get the computer choice
    public String computerChoice() {
        Random random = new Random();
        String response = choice[random.nextInt(3)];
        return response;
    }

    // Make decision for winners
    public void getDecision(String playerResponse, String computerResponse) {
        if(playerResponse.equals(computerResponse)) {
            System.out.println("\nResult: Tie Game!");
        } else {
            switch(playerResponse) {
                case "ROCK" -> {
                    if(computerResponse.equals("PAPER")) {
                        this.scoreComputer += 1;
                        System.out.println("\nResult: Computer win!");
                    }

                    if(computerResponse.equals("SCISSOR")) {
                        this.scorePlayer += 1;
                        System.out.println("\nResult: You win!");
                    }
                }
                case "PAPER" -> {
                    if(computerResponse.equals("ROCK")) {
                        this.scorePlayer += 1;
                        System.out.println("\nResult: You win!");
                    }

                    if(computerResponse.equals("SCISSOR")) {
                        this.scoreComputer += 1;
                        System.out.println("\nResult: Computer win!");
                    }
                }
                case "SCISSOR" -> {
                    if(computerResponse.equals("ROCK")) {
                        this.scoreComputer += 1;
                        System.out.println("\nResult: Computer win!");
                    }

                    if(computerResponse.equals("PAPER")) {
                        this.scorePlayer += 1;
                        System.out.println("\nResult: You win!");
                    }
                }
            }
        }
    }

    // Get winner of the game
    public void getWinner() {
        System.out.println("Player Score: " + this.scorePlayer);
        System.out.println("Computer Score: " + this.scoreComputer);

        if(this.scorePlayer == 3) {
            System.out.println("\nCongratulations! You are the winner!");
            System.out.println("You won 10 tickets!");
            winnerPlayer = "Player";
            System.out.print("\n########################################################################################################\n");
        }

        if(this.scoreComputer == 3) {
            System.out.println("\nBetter luck next time! The winner is Computer");
            System.out.println("You won 5 tickets!");
            winnerPlayer = "Computer";
            System.out.print("\n########################################################################################################\n");
        }
    }
    
    // Get the prize ticket
    public int getTicket() {
        if(winnerPlayer.equals("Player")) {
            return 10;
        }

        if(winnerPlayer.equals("Computer")) {
            return 5;
        }

        return 0;
    }
}
