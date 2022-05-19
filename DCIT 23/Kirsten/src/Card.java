import java.util.UUID; 

public class Card {
    private int player_credit_balance = 0;
    private int player_ticket_balance = 0;
    private UUID card_number;

    Card() {
        UUID uniqueId = UUID.randomUUID(); 
        this.player_credit_balance = 0;
        this.player_ticket_balance = 0;  
        this.card_number = uniqueId;
    }

    public int getCredit() {
        return this.player_credit_balance;
    }
    
    public int getCurrentTicket() {
        return this.player_ticket_balance;
    }

    public void setTransferredTickets(double tickets) {
        this.player_ticket_balance += tickets;
    }

    public void reduceTicket(int amount){
        if(this.player_ticket_balance >= amount) {
            this.player_ticket_balance -= amount;
        }
    }

    public void setCredit(double amount){
        if(amount >= 0) {
            player_credit_balance += (amount * 2);
        }
    }

    public void setTicket(int tickets){
        if(tickets > 0) {
            this.player_ticket_balance += tickets;
        }
    }

    public void reduceCredit(double amount){
        if(player_credit_balance >= amount) {
            player_credit_balance -= amount;
        }   
    }

    public void setTransferredCredits(double credits) {
        this.player_credit_balance += credits;
    }

    public void getCardInformation() {
        System.out.println("Your Card Details:");
        System.out.println("Your Credit Balance: " + this.player_credit_balance);
        System.out.println("Your Ticket Balance: " + this.player_ticket_balance);
        System.out.println("Your Card Number: " + this.card_number);
    }
}