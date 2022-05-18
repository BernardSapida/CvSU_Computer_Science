import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {
    private Card card1 = new Card(0, 0);
    private Card card2 = new Card(0, 0);
    private Card currentCard = card1;
    private String[] playerPrizeInventoryName = new String[3];
    private int[] playerPrizeInventoryQuantity = new int[3];
    private int[] arcadePrizeInventoryQuantity = new int[3];

    Test() {
        this.playerPrizeInventoryName[0] = "Pikachu Stuffed Toy";
        this.playerPrizeInventoryName[1] = "Doraemon Stuffed Toy";
        this.playerPrizeInventoryName[2] = "Big Charmander Stuffed Toy";
        this.playerPrizeInventoryQuantity[0] = 0;
        this.playerPrizeInventoryQuantity[1] = 0;
        this.playerPrizeInventoryQuantity[2] = 0;

        this.arcadePrizeInventoryQuantity[0] = 20;
        this.arcadePrizeInventoryQuantity[1] = 20;
        this.arcadePrizeInventoryQuantity[2] = 20;
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        
        // Loop
        while(true) {
            test.playArcade();
        }
    }

    // Invoke player's chosen action
    public void playArcade() {
        String selectedOption = getAction();

        switch(selectedOption) {
            case "1" -> { arcadeGame(); }
            case "2" -> { prizeCategories(); }
            case "3" -> { terminals(); }
            case "4" -> { exit(); }
        }
    }

    // Print player inventory items and its quantity
    public void getWonPrizes() {
        System.out.println("\nYour Inventory: ");
        System.out.println("1) " + playerPrizeInventoryName[0] + " => " + playerPrizeInventoryQuantity[0] + "x");
        System.out.println("2) " + playerPrizeInventoryName[1] + " => " + playerPrizeInventoryQuantity[1] + "x");
        System.out.println("3) " + playerPrizeInventoryName[2] + " => " + playerPrizeInventoryQuantity[2] + "x");
    }

    // Print arcade inventory items and its quantity
    public void getArcadeInventory() {
        System.out.println("\nArcade Inventory: ");
        System.out.println("1) " + playerPrizeInventoryName[0] + " => " + arcadePrizeInventoryQuantity[0] + "x");
        System.out.println("2) " + playerPrizeInventoryName[1] + " => " + arcadePrizeInventoryQuantity[1] + "x");
        System.out.println("3) " + playerPrizeInventoryName[2] + " => " + arcadePrizeInventoryQuantity[2] + "x");
    }

    // Arcade Game Options
    public void arcadeGame() {
        Scanner inArcadeGame = new Scanner(System.in);
        System.out.println("\n########################################################################################################\n");
        System.out.println("Select your game: ");
        System.out.println("[1] => Rock, Paper, and Scissor!");
        System.out.println("[2] => Number Guessing");
        System.out.println("[3] => Back");
        System.out.print("Choose a number: ");
        String game = inArcadeGame.nextLine();

        while(!Pattern.compile("^(1|2|3)$").matcher(game).find()) {
            System.out.println("Your input is invalid!\n");
            System.out.println("Select your game: ");
            System.out.println("[1] => Rock, Paper, and Scissor! (5 Credits)");
            System.out.println("[2] => Number Guessing! (3 Credits)");
            System.out.println("[3] => Back");
            System.out.print("Choose a number: ");
            game = inArcadeGame.nextLine();
        }

        switch(game) {
            case "1" -> { startRPS(); }
            case "2" -> { startNumberGuessing(); }
            case "3" -> { playArcade(); }
        }
    }

    // Rock Paper Scissor Game
    public void startRPS() {
        if(currentCard.getCurrentCredit() > 5) {
            currentCard.reduceCredit(5);

            Rps rpsGame = new Rps();

            rpsGame.startRps();
            currentCard.setTransferredTickets(rpsGame.getTicket());
            System.out.println();
            currentCard.getCardDetails();
        } else {
            System.out.println("You have insufficient credit balance, please top-up!");
        }
    }

    // Number Guessing Game
    public void startNumberGuessing() {
        if(currentCard.getCurrentCredit() > 3) {
            currentCard.reduceCredit(3);
            GuessNumber guessNumberGame = new GuessNumber();
            guessNumberGame.startGuessNumber();
            currentCard.setTransferredTickets(guessNumberGame.getTicket());
            currentCard.getCardDetails();
        } else {
            System.out.println("You have insufficient credit balance, please top-up!");
        }
    }

    // Prize Categories and ticket requirements
    public void prizeCategories() {
        System.out.println("\n########################################################################################################\n");
        
        currentCard.getCardDetails();

        Scanner inPrizeCategories = new Scanner(System.in);
        System.out.println("\n[1]: Pikachu Stuffed Toy (Small Size) => 10 Tickets");
        System.out.println("[2]: Doraemon Stuffed Toy (Medium Size) => 50 Tickets");
        System.out.println("[3]: Big Charmander Stuffed Toy (Large Size) => 100 Tickets");
        System.out.println("[4]: Back");
        System.out.print("Choose a number: ");
        String option = inPrizeCategories.nextLine();

        while(!Pattern.compile("^(1|2|3|4)$").matcher(option).find()) {
            System.out.println("Your input is invalid!\n");
            System.out.println("Prize Option: ");
            System.out.println("[1]: Pikachu Stuffed Toy (Tickets: 10)");
            System.out.println("[2]: Doraemon Stuffed Toy (Tickets: 50)");
            System.out.println("[3]: Big Charmander Stuffed Toy (Tickets: 100)");
            System.out.print("Choose a number: ");
            option = inPrizeCategories.nextLine();
        }
        
        if(option.equals("1")) {
            if(currentCard.getCurrentTicket() >= 10 && arcadePrizeInventoryQuantity[0] != 0) {
                currentCard.reduceTicket(10);
                System.out.println("\nCongratulations! You have Pikachu Stuffed Toy (Small Size) in you inventory!");
                playerPrizeInventoryQuantity[0] += 1;
                arcadePrizeInventoryQuantity[0] -= 1;
                getWonPrizes();
                getArcadeInventory();
            } else {
                if(currentCard.getCurrentTicket() < 100) System.out.println("You have insufficient ticket to obtain this reward!");
                else if(arcadePrizeInventoryQuantity[0] == 0) System.out.println("This reward is out of stock!");
            }
        }

        if(option.equals("2")) {
            if(currentCard.getCurrentTicket() >= 50 && arcadePrizeInventoryQuantity[1] != 0) {
                currentCard.reduceTicket(50);
                System.out.println("Congratulations! You have Doraemon Stuffed Toy (Medium Size) in you inventory!");
                playerPrizeInventoryQuantity[1] += 1;
                arcadePrizeInventoryQuantity[1] -= 1;
                getWonPrizes();
                getArcadeInventory();
            } else {
                if(currentCard.getCurrentTicket() < 100) System.out.println("You have insufficient ticket to obtain this reward!");
                else if(arcadePrizeInventoryQuantity[1] == 0) System.out.println("This reward is out of stock!");
            }
        }

        if(option.equals("3")) {
            if(currentCard.getCurrentTicket() >= 100 && arcadePrizeInventoryQuantity[2] != 0) {
                currentCard.reduceTicket(100);
                System.out.println("Congratulations! You have Big Charmander Stuffed Toy (Large Size) in you inventory!");
                playerPrizeInventoryQuantity[2] += 1;
                arcadePrizeInventoryQuantity[2] -= 1;
                getWonPrizes();
                getArcadeInventory();
            } else {
                if(currentCard.getCurrentTicket() < 100) System.out.println("You have insufficient ticket to obtain this reward!");
                else if(arcadePrizeInventoryQuantity[2] == 0) System.out.println("This reward is out of stock!");
            }
        }

        if(option.equals("4")) {
            playArcade();
        }
    }

    // Terminal
    public void terminals() {
        System.out.println("\n########################################################################################################\n");
        Scanner inTerminals = new Scanner(System.in);
        System.out.println("Select your game: ");
        System.out.println("[1] => Change Card");
        System.out.println("[2] => Transfer Credit & Tickets");
        System.out.println("[3] => Add Credits");
        System.out.println("[4] => Check Card Balance");
        System.out.println("[5] => Back");
        System.out.print("Choose a number: ");
        String option = inTerminals.nextLine();

        while(!Pattern.compile("^(1|2|3|4|5)$").matcher(option).find()) {
            System.out.println("Your input is invalid!\n");
            System.out.println("Select your game: ");
            System.out.println("[1] => Change Card");
            System.out.println("[2] => Transfer Credit & Tickets");
            System.out.println("[3] => Add Credits");
            System.out.println("[4] => Check Card Balance");
            System.out.println("[5] => Back");
            System.out.print("Choose a number: ");
            option = inTerminals.nextLine();
        }

        switch(option) {
            case "1" -> { changeCard(); }
            case "2" -> { transferCT(); }
            case "3" -> { addCredit(); }
            case "4" -> { getCardBalance(); }
            case "5" -> { playArcade(); }
        }
    }

    // Change Card
    public void changeCard() {
        Scanner inChangeCard = new Scanner(System.in);
        System.out.println("\n########################################################################################################\n");
        System.out.println("Card #1");
        card1.getCardDetails();
        System.out.println("\nCard #2");
        card2.getCardDetails();
        System.out.println("\nSelect Card:");
        System.out.println("[1] => Card 1");
        System.out.println("[2] => Card 2");
        System.out.print("Choose a number: ");
        String card = inChangeCard.nextLine();

        while(!Pattern.compile("^(1|2)$").matcher(card).find()) {
            System.out.println("Your input is invalid!\n");
            System.out.println("Select Card:");
            System.out.println("[1] => Card 1");
            System.out.println("[2] => Card 2");
            System.out.print("Choose a number: ");
            card = inChangeCard.nextLine();
        }

        if(card.equals("1")) this.currentCard = card1;
        if(card.equals("2")) this.currentCard = card2;

        this.currentCard.getCardDetails();
    }

    // Transfer Credit or Tickets
    public void transferCT() {
        System.out.println("\n########################################################################################################\n");
        System.out.println("Card #1");
        card1.getCardDetails();

        System.out.println("\nCard #2");
        card2.getCardDetails();

        Scanner inTransferCT = new Scanner(System.in);

        if(currentCard == card1) {
            System.out.print("\nEnter amount of credits to transfer to Card 2: ");
            String credits = inTransferCT.nextLine();

            while(!Pattern.compile("^[0-9]+$").matcher(credits).find()) {
                System.out.println("Your input is invalid!\n");
                System.out.print("Enter amount of credits to transfer to Card 2: ");
                credits = inTransferCT.nextLine();
            }

            System.out.print("Enter amount of tickets to transfer to Card 2: ");
            String tickets = inTransferCT.nextLine();

            while(!Pattern.compile("^[0-9]+$").matcher(tickets).find()) {
                System.out.println("Your input is invalid!\n");
                System.out.print("Enter amount of tickets to transfer to Card 2: ");
                tickets = inTransferCT.nextLine();
            }

            if(currentCard.getCurrentCredit() >= Integer.parseInt(credits)) { 
                currentCard.reduceCredit(Integer.parseInt(credits));
                card2.setTransferredCredits(Integer.parseInt(credits));
                System.out.println("Credits successfully transferred!");
            } else {
                System.out.println("Your input is greater than your card 1 credits!");
            }

            if(currentCard.getCurrentTicket() >= Integer.parseInt(tickets)) { 
                currentCard.reduceTicket(Integer.parseInt(tickets));
                card2.setTransferredTickets(Integer.parseInt(tickets));
                System.out.println("Tickets successfully transferred!");
            } else {
                System.out.println("Your input is greater than your card 1 tickets!");
            }
        }

        if(currentCard == card2) {
            System.out.print("\nEnter amount of credits to transfer to Card 1: ");
            String credits = inTransferCT.nextLine();

            while(!Pattern.compile("^[0-9]+$").matcher(credits).find()) {
                System.out.println("Your input is invalid!\n");
                System.out.print("Enter amount of credits to transfer to Card 2: ");
                credits = inTransferCT.nextLine();
            }

            System.out.print("Enter amount of tickets to transfer to Card 1: ");
            String tickets = inTransferCT.nextLine();

            while(!Pattern.compile("^[0-9]+$").matcher(tickets).find()) {
                System.out.println("Your input is invalid!\n");
                System.out.print("Enter amount of tickets to transfer to Card 2: ");
                tickets = inTransferCT.nextLine();
            }  

            System.out.println(currentCard.getCurrentCredit() + " " + Integer.parseInt(credits));

            if(currentCard.getCurrentCredit() >= Integer.parseInt(credits)) { 
                currentCard.reduceCredit(Integer.parseInt(credits));
                card2.setTransferredCredits(Integer.parseInt(credits));
                System.out.println("Credits successfully transferred!");
            } else {
                System.out.println("Your input is greater than your card 1 credits!");
            }

            if(currentCard.getCurrentTicket() >= Integer.parseInt(tickets)) { 
                currentCard.reduceTicket(Integer.parseInt(tickets));
                card2.setTransferredTickets(Integer.parseInt(tickets));
                System.out.println("Tickets successfully transferred!");
            } else {
                System.out.println("Your input is greater than your card 1 tickets!");
            }
        }
    }

    // Add Credit or Load Credits
    public void addCredit() {
        System.out.println("\n########################################################################################################\n");
        Scanner inAddCredit = new Scanner(System.in);
        System.out.println("Note:\n$1 dollar = 2 game credits\n");
        System.out.print("Enter amount to load credits: ");
        String amount = inAddCredit.nextLine();

        while(!Pattern.compile("^[0-9]+$").matcher(amount).find()) {
            System.out.println("Your input is invalid!\n");
            System.out.print("Enter amount to load credits: ");
            amount = inAddCredit.nextLine();
        }

        currentCard.setCredit(Integer.parseInt(amount));
        System.out.println("Successful transaction!\n");

        currentCard.getCardDetails();
    }

    // Print card 1 and card 2 balance
    public void getCardBalance() {
        System.out.println("\n########################################################################################################\n");
        System.out.println("Card #1");
        card1.getCardDetails();
        System.out.println("\nCard #2");
        card2.getCardDetails();
    }

    public void exit() {
        System.out.println("Thank you for coming and playing in our arcade! We hope you'll enjoy and come back here soon.");
        System.exit(0);
    }

    // Promt user to enter actions
    public String getAction() {
        Scanner in_action = new Scanner(System.in);
        System.out.println("\n########################################################################################################\n");
        System.out.println("[1] => Games");
        System.out.println("[2] => Prize Categories");
        System.out.println("[3] => Terminals");
        System.out.println("[4] => Exit");
        System.out.print("Choose a number: ");
        String action = in_action.next();

        while(!Pattern.compile("^(1|2|3|4)$").matcher(action).find()) {
            System.out.println("Your input is invalid!\n");
            System.out.println("[1] => Games");
            System.out.println("[2] => Prize Categories");
            System.out.println("[3] => Terminals");
            System.out.println("[4] => Exit");
            System.out.print("Choose a number: ");
            action = in_action.nextLine();
        }

        return action;
    }
}