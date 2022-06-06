public class Passenger extends Bus {
    private int acct;
    private int balance;

    public Passenger(int acct, int balance) {
        super(balance);
        this.acct = acct;
        this.balance = balance;
    }

    public void displayInfo() {
        super.displayInfo();
        super.getInfo();
        super.calculateFare();

        System.out.println();
        System.out.println("Account: " + acct);
        System.out.println("Fare: 70");
        System.out.println("User Balance: " + balance);

        if(is_sufficient) {
            System.out.println("Remaining Balance: " + remaining_balance);
        } else {
            System.out.println("Insufficient Balance!");
        }

        System.out.println();
    }
}
