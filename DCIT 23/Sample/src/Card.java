import java.util.UUID; 

public class Card {
    private int creditBalance; // Should be positive
    private int ticketBalance; // Game reward tickets
    private UUID cardNumber;   // Player Unique Card

    // Instantiating Card Class
    Card() {
        UUID uuid = UUID.randomUUID(); 
        this.creditBalance = 0;
        this.ticketBalance = 0;  
        this.cardNumber = uuid;
    }

    public void setTicketBalance(int ticketAmount) {
        this.ticketBalance += ticketAmount;
    }

    public void getCardInfo() {
        System.out.println("Credit Balance: " + this.creditBalance);
        System.out.println("Ticket Balance: " + this.ticketBalance);
        System.out.println("Card Number: " + this.cardNumber);
    }
}