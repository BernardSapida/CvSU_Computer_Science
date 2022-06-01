public class Passenger extends Bus {
    private long acct;
    private int balance;

    // Calling the superclass constructor.
    public Passenger(long acct, int balance) {
        super(balance);
        
        this.acct = acct;
        this.balance = balance;
    }

    /**
     * This function displays the commuter's information, gets the commuter's information, displays the
     * commuter's account number, displays the fare, displays the commuter's balance, calculates the
     * commuter's fare, and displays the commuter's remaining balance
     */
    public void displayInfo() {
        super.displayInfo();
        super.getInfo();

        System.out.println("Account: " + acct);
        System.out.println("Fare: 70");
        System.out.println("Your Balance: " + balance);
        super.calculateFare();
        if(sufficientBalance) System.out.println("Remaining Balance: " + commuterBalance  + "\n");
    }
}
