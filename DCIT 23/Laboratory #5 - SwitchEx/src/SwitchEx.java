import java.util.Scanner;
import java.util.regex.Pattern;

public class SwitchEx {
    // SwitchEx1 Fields
    public static Scanner in = new Scanner(System.in);
    public static String month;

    public static void main(String[] args) throws Exception {
        // Invoking getMonth methods
        while(true) {
            getMonth();
        }
    }

    public static void getMonth() {
        // Ask for Month Number
        System.out.print("\nEnter Month Number: ");
        month = in.nextLine();

        // Validate user input
        while(!Pattern.compile("^[0-9]+$").matcher(String.valueOf(month)).find()) {
            System.out.println("Invalid input!");
            System.out.print("\nEnter Month Number: ");
            month = in.nextLine();
        }

        switch(Integer.parseInt(month)) {
            case 1 -> { System.out.println("Month: January"); }
            case 2 -> { System.out.println("Month: February"); }
            case 3 -> { System.out.println("Month: March"); }
            case 4 -> { System.out.println("Month: April"); }
            case 5 -> { System.out.println("Month: May"); }
            case 6 -> { System.out.println("Month: June"); }
            case 7 -> { System.out.println("Month: July"); }
            case 8 -> { System.out.println("Month: August"); }
            case 9 -> { System.out.println("Month: September"); }
            case 10 -> { System.out.println("Month: October"); }
            case 11 -> { System.out.println("Month: November"); }
            case 12 -> { System.out.println("Month: December"); }
            default -> { System.out.println("Invalid month!"); }
        }
    }
}