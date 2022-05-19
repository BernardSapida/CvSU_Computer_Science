import java.util.Scanner;

public class Test {
    private Card player_card_1 = new Card();
    private Card player_card_2 = new Card();
    private Card active_card = player_card_1;
    private String[] prizesName = new String[3];
    private int[] accumulatedPrizes = new int[3];
    private int[] remainingPrizes = new int[3];

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        
        while(true) {
            test.player_options();
        }
    }

    public void transferBalance() {
        System.out.println("\n");
        System.out.println("Player Card #1");
        player_card_1.getCardInformation();

        System.out.println("\nPlayer Card #2");
        player_card_2.getCardInformation();

        Scanner scanner_5 = new Scanner(System.in);

        if(active_card == player_card_1) {
            System.out.print("\nAmount of credits to transfer to another card: ");
            String credits = scanner_5.nextLine();

            System.out.print("Amount of tickets to transfer to another card: ");
            String tickets = scanner_5.nextLine();

            if(active_card.getCredit() >= Integer.parseInt(credits)) { 
                active_card.reduceCredit(Integer.parseInt(credits));
                player_card_2.setTransferredCredits(Integer.parseInt(credits));
                System.out.println("Transferred Successfully!");
            } else {
                System.out.println("Your input is too large compare to you another card credits!");
            }

            if(active_card.getCurrentTicket() >= Integer.parseInt(tickets)) { 
                active_card.reduceTicket(Integer.parseInt(tickets));
                player_card_2.setTransferredTickets(Integer.parseInt(tickets));
                System.out.println("Transferred Successfully!");
            } else {
                System.out.println("Your input is too large compare to you another card tickets!");
            }
        }

        if(active_card == player_card_2) {
            System.out.print("\nAmount of credits to transfer to another card: ");
            String credits = scanner_5.nextLine();

            System.out.print("Amount of tickets to transfer to another card: ");
            String tickets = scanner_5.nextLine();

            System.out.println(active_card.getCredit() + " " + Integer.parseInt(credits));

            if(active_card.getCredit() >= Integer.parseInt(credits)) { 
                active_card.reduceCredit(Integer.parseInt(credits));
                player_card_2.setTransferredCredits(Integer.parseInt(credits));
                System.out.println("Transferred Successfully!");
            } else {
                System.out.println("Your input is too large compare to you another card credits!");
            }

            if(active_card.getCurrentTicket() >= Integer.parseInt(tickets)) { 
                active_card.reduceTicket(Integer.parseInt(tickets));
                player_card_2.setTransferredTickets(Integer.parseInt(tickets));
                System.out.println("Transferred Successfully!");
            } else {
                System.out.println("Your input is too large compare to you another card tickets!");
            }
        }
    }

    Test() {
        this.prizesName[0] = "Earphones";
        this.prizesName[1] = "Mousepad";
        this.prizesName[2] = "Bluetooth Speaker";

        this.accumulatedPrizes[0] = 0;
        this.accumulatedPrizes[1] = 0;
        this.accumulatedPrizes[2] = 0;

        this.remainingPrizes[0] = 20;
        this.remainingPrizes[1] = 20;
        this.remainingPrizes[2] = 20;
    }

    public void arcadeGame() {
        Scanner scanner_1 = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Select your game: ");
        System.out.println("(1) => Rock Paper Scissor Game");
        System.out.println("(2) => Number Guessing Game");
        System.out.println("(3) => Back");
        System.out.print("Enter a number: ");
        String game = scanner_1.nextLine();

        if(game.equals("1")) {
            startRPS();
        }

        if(game.equals("2")) {
            startNumberGuessing();
        }

        if(game.equals("3")) {
            player_options();
        }
    }

    public void startRPS() {
        if(active_card.getCredit() > 5) {
            active_card.reduceCredit(5);

            RockPaperScissor rpsGame = new RockPaperScissor();

            rpsGame.startRps();
            active_card.setTransferredTickets(rpsGame.getTicket());
            System.out.println();
            active_card.getCardInformation();
        } else {
            System.out.println("Not enough balance, please add credits now!");
        }
    }

    public void printPlayerPrizes() {
        System.out.println("\nYour Accumulated Prizes: ");
        System.out.println("1) " + prizesName[0] + ": " + accumulatedPrizes[0] + "pcs");
        System.out.println("2) " + prizesName[1] + ": " + accumulatedPrizes[1] + "pcs");
        System.out.println("3) " + prizesName[2] + ": " + accumulatedPrizes[2] + "pcs");
    }

    public void arcadePrizeCategories() {
        System.out.println("\n");
        
        active_card.getCardInformation();

        Scanner scanner_2 = new Scanner(System.in);
        System.out.println("\n(1): Earphones = 10 Tickets");
        System.out.println("(2): Mousepad = 50 Tickets");
        System.out.println("(3): Bluetooth Speaker = 100 Tickets");
        System.out.println("(4): Back");
        System.out.print("Enter a number: ");
        String option = scanner_2.nextLine();
        
        if(option.equals("1")) {
            if(active_card.getCurrentTicket() >= 10 && remainingPrizes[0] != 0) {
                active_card.reduceTicket(10);
                System.out.println("\nExchange Successful! You have new earphones in your bag!");
                accumulatedPrizes[0] += 1;
                remainingPrizes[0] -= 1;
                printPlayerPrizes();
                getRemainingItems();
            } else {
                if(active_card.getCurrentTicket() < 100) {
                    System.out.println("Not enough ticket to get this reward!");
                } else if(remainingPrizes[0] == 0) {
                    System.out.println("This reward is out of stock!");
                }
            }
        }

        if(option.equals("2")) {
            if(active_card.getCurrentTicket() >= 50 && remainingPrizes[1] != 0) {
                active_card.reduceTicket(50);
                System.out.println("Exchange Successful! You have new mousepad in your bag!");
                accumulatedPrizes[1] += 1;
                remainingPrizes[1] -= 1;
                printPlayerPrizes();
                getRemainingItems();
            } else {
                if(active_card.getCurrentTicket() < 100) System.out.println("Not enough ticket to get this reward!");
                else if(remainingPrizes[1] == 0) System.out.println("This reward is out of stock!");
            }
        }

        if(option.equals("3")) {
            if(active_card.getCurrentTicket() >= 100 && remainingPrizes[2] != 0) {
                active_card.reduceTicket(100);
                System.out.println("Exchange Successful! You have new bluetooth speaker in your bag!");
                accumulatedPrizes[2] += 1;
                remainingPrizes[2] -= 1;
                printPlayerPrizes();
                getRemainingItems();
            } else {
                if(active_card.getCurrentTicket() < 100) System.out.println("Not enough ticket to get this reward!");
                else if(remainingPrizes[2] == 0) System.out.println("This reward is out of stock!");
            }
        }

        if(option.equals("4")) {
            player_options();
        }
    }


    public void getRemainingItems() {
        System.out.println("\nArcade Remaining Prizes: ");
        System.out.println("1) " + prizesName[0] + ": " + remainingPrizes[0] + "pcs");
        System.out.println("2) " + prizesName[1] + ": " + remainingPrizes[1] + "pcs");
        System.out.println("3) " + prizesName[2] + ": " + remainingPrizes[2] + "pcs");
    }

    public void terminal() {
        System.out.println("\n");
        Scanner scanner_3 = new Scanner(System.in);
        System.out.println("Choose below: ");
        System.out.println("(1) => Change Arcade Card");
        System.out.println("(2) => Transfer Arcade Credit & Tickets");
        System.out.println("(3) => Add Arcade Credits");
        System.out.println("(4) => Check Card Balance");
        System.out.println("(5) => Back");
        System.out.print("Enter a number: ");
        String option = scanner_3.nextLine();

        if(option.equals("1")) {
            changeCard();
        }

        if(option.equals("2")) {
            transferBalance();
        }

        if(option.equals("3")) {
            addCreditToCard();
        }

        if(option.equals("4")) {
            getBalance();
        }

        if(option.equals("5")) {
            player_options();
        }
    }

    public void changeCard() {
        Scanner scanner_4 = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Player Card #1");
        player_card_1.getCardInformation();
        System.out.println("\nPlayer Card #2");
        player_card_2.getCardInformation();
        System.out.println("\nSelect Card:");
        System.out.println("(1) => Player Card 1");
        System.out.println("(2) => Player Card 2");
        System.out.print("Enter a number: ");
        String card = scanner_4.nextLine();

        if(card.equals("1")) {
            this.active_card = player_card_1;
        }

        if(card.equals("2")) {
            this.active_card = player_card_2;
        }

        this.active_card.getCardInformation();
    }

    public void startNumberGuessing() {
        if(active_card.getCredit() > 3) {
            active_card.reduceCredit(3);
            GuessNumber guessNumberGame = new GuessNumber();
            guessNumberGame.startGuessNumber();
            active_card.setTransferredTickets(guessNumberGame.getTicket());
            active_card.getCardInformation();
        } else {
            System.out.println("Not enough balance, please add credits now!");
        }
    }

    public void player_options() {
        String inputs = getInput();

        if(inputs.equals("1")) {
            arcadeGame();
        }

        if(inputs.equals("2")) {
            arcadePrizeCategories();
        }

        if(inputs.equals("3")) {
            terminal();
        }

        if(inputs.equals("4")) {
            exit();
        }
    }

    public void addCreditToCard() {
        System.out.println("\n");
        Scanner scanner_6 = new Scanner(System.in);
        System.out.println("Note: for every 1 dollar, you will receive 2 credits\n");
        System.out.print("Enter an amount: ");
        String amount = scanner_6.nextLine();

        active_card.setCredit(Integer.parseInt(amount));
        System.out.println("Successful transnumber!\n");

        active_card.getCardInformation();
    }

    public void getBalance() {
        System.out.println("\n");
        
        System.out.println("Player Card #1");
        player_card_1.getCardInformation();

        System.out.println("\nPlayer Card #2");
        player_card_2.getCardInformation();
    }

    public void exit() {
        System.out.println("Hello player! Thank you for playing arcades, keep safe and godbless!");
        System.exit(0);
    }

    public String getInput() {
        Scanner scanner_7 = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("(1) => Arcade Game");
        System.out.println("(2) => Arcade Prize Categories");
        System.out.println("(3) => Arcade Terminal");
        System.out.println("(4) => Arcade Exit");
        System.out.print("Enter a number: ");
        String number = scanner_7.next();

        return number;
    }
}