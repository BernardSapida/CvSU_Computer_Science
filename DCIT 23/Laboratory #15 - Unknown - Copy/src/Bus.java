public class Bus extends Driver {
    String plate_number = "CTB 947";
    String origin = "Trece";
    String destination = "PITX";
    int fare = 70;
    int remaining_balance;
    boolean is_sufficient = false;

    public Bus(int balance) {
        this.remaining_balance = balance;
    }

    public void displayInfo() {
        System.out.println();
        System.out.println("Bus: " + plate_number);
        System.out.println("Origin: " + origin);
        System.out.println("Destination: " + destination);
        System.out.println("Basic Fare: " + fare);
        System.out.println();
    }

    public void getInfo() {
        System.out.println("Driver: " + driverName);
        System.out.println("License Number: " + licenseNumber);
    }

    public void calculateFare() {
        if(remaining_balance > 70) {
            remaining_balance -= 70;
            is_sufficient = true;
        }
    }
}
