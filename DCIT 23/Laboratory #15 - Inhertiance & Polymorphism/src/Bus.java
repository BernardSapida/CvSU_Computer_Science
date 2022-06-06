public class Bus extends Driver {
    protected String busPlateNumber = "XYZ 123";
    protected String origin = "Indang";
    protected String destination = "PITX";
    protected int fare = 70;
    protected int commuterBalance;
    protected boolean sufficientBalance = false;

    // A constructor that takes in an integer parameter and sets the commuterBalance variable to the
    // parameter.
    public Bus(int commuterBalance) {
        this.commuterBalance = commuterBalance;
    }

    /**
     * If the commuter's balance is less than 70, print "Insufficient Balance!"; otherwise, subtract 70
     * from the commuter's balance and set sufficientBalance to true
     */
    public void calculateFare() {
        if(commuterBalance < 70) {
            System.out.println("Insufficient Balance!");
        } else {
            commuterBalance -= 70;
            sufficientBalance = true;
        }
    }

    // Calculate the payment made by the passenger.
    // Display transaction, balance if any or insufficient payment.
    public void displayInfo() {
        System.out.println("\nBus: " + busPlateNumber);
        System.out.println("Origin: " + origin);
        System.out.println("Destination: " + destination);
        System.out.println("Basic Fare: " + fare + "\n");
    }

    /**
     * This function prints out the driver's name, license number, and bus assignment
     */
    public void getInfo() {
        System.out.println("Driver: " + driverName);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Bus Assign: " + busAssign + "\n");
    }
}
