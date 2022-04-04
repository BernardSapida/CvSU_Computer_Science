import java.util.Scanner;
import java.util.regex.Pattern;

public class SwitchEx1 {
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
        while(!Pattern.compile("^(([0][1-9])|([1-9])|(1[0-2]))$").matcher(String.valueOf(month)).find()) {
            System.out.println("Invalid month!");
            System.out.print("\nEnter Month Number: ");
            month = in.nextLine();
        }

        switch(Integer.parseInt(month)) {
            case 1 -> { System.out.println("The month number "+month+" is January"); }
            case 2 -> { System.out.println("The month number "+month+" is February"); }
            case 3 -> { System.out.println("The month number "+month+" is March"); }
            case 4 -> { System.out.println("The month number "+month+" is April"); }
            case 5 -> { System.out.println("The month number "+month+" is May"); }
            case 6 -> { System.out.println("The month number "+month+" is June"); }
            case 7 -> { System.out.println("The month number "+month+" is July"); }
            case 8 -> { System.out.println("The month number "+month+" is August"); }
            case 9 -> { System.out.println("The month number "+month+" is September"); }
            case 10 -> { System.out.println("The month number "+month+" is October"); }
            case 11 -> { System.out.println("The month number "+month+" is November"); }
            case 12 -> { System.out.println("The month number "+month+" is December"); }
        }
    }
}