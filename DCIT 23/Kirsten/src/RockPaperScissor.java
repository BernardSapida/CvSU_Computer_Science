import java.util.*;
import java.util.regex.Pattern;

public class RockPaperScissor {
    private int player_score = 0;
    private int computer_score = 0;
    private String[] choice= {"ROCK", "PAPER", "SCISSOR"};
    private String winner = "";

    RockPaperScissor() {
        System.out.println("\n");
        System.out.println("ROCK, PAPER, SCISSOR GAME!");
        System.out.println("Information: You need to win against the random response of a computer and first who will reach 3 points win the game! Goodluck player!");
        System.out.println("Prizes:");
        System.out.println("When you win then you'll received 7 tickets");
        System.out.println("When you lose then you'll received 3 tickets");
        System.out.println("\n");
        System.out.println("GAME STARTED!");
    }

    public void startRps() {
        Scanner rps_in = new Scanner(System.in);
        
        while(winner.equals("")) {
            String computerResponse = computerChoice();

            System.out.print("\nYour response (Rock, Paper, Scissor): ");
            String playerResponse = rps_in.nextLine().toUpperCase();

            System.out.println("You choose: " + playerResponse);
            System.out.println("Computer choose: " + computerResponse);
            getDecision(playerResponse, computerResponse);

            getWinner();
        }
    }

    public String computerChoice() {
        Random random = new Random();
        String response = choice[random.nextInt(3)];
        return response;
    }

    public int getTicket() {
        if(winner.equals("Player")) {
            return 10;
        }
        if(winner.equals("Computer")) {
            return 5;
        }
        return 0;
    }

    public void getWinner() {
        System.out.println("Your Score: " + this.player_score);
        System.out.println("Computer Score: " + this.computer_score);

        if(this.player_score == 3) {
            System.out.println("\nYou are the winner!");
            System.out.println("You received 7 tickets!");
            winner = "Player";
        }

        if(this.computer_score == 3) {
            System.out.println("\nThe winner is Computer");
            System.out.println("You received 3 tickets!");
            winner = "Computer";
        }

        System.out.print("\n\n");
    }

    public void getDecision(String playerResponse, String computerResponse) {
        if(playerResponse.equals(computerResponse)) {
            System.out.println("\nResult: Tie Game!");
        } else {
            if(playerResponse.equals("ROCK")) {
                if(computerResponse.equals("PAPER")) {
                    this.computer_score += 1;
                    System.out.println("\nResult: Computer win!");
                }

                if(computerResponse.equals("SCISSOR")) {
                    this.player_score += 1;
                    System.out.println("\nResult: You win!");
                }
            }

            if(playerResponse.equals("PAPER")) {
                if(computerResponse.equals("ROCK")) {
                    this.player_score += 1;
                    System.out.println("\nResult: You win!");
                }

                if(computerResponse.equals("SCISSOR")) {
                    this.computer_score += 1;
                    System.out.println("\nResult: Computer win!");
                }
            }

            if(playerResponse.equals("SCISSOR")) {
                if(computerResponse.equals("ROCK")) {
                    this.computer_score += 1;
                    System.out.println("\nResult: Computer win!");
                }

                if(computerResponse.equals("PAPER")) {
                    this.player_score += 1;
                    System.out.println("\nResult: You win!");
                }
            }
        }
    }
}
