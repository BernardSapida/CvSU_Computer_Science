import java.util.Scanner;
import java.util.regex.Pattern;

public class ShoppingCart {
    // ShoppingCart Fields
    public static Scanner in = new Scanner(System.in);
    public static boolean outOfStock;
    public static String quantity;

    public static void main(String[] args) throws Exception {
        // Invoking getNumberOfStock methods
        while(true) {
            getNumberOfStock();
        }
    }

    public static void getNumberOfStock() {
        // Ask for product's quantity
        System.out.print("\nEnter product quantity: ");
        quantity = in.nextLine();

        // Validate user input
        while(!Pattern.compile("^[0-9]+$").matcher(String.valueOf(quantity)).find()) {
            System.out.println("Your input is invalid!");
            System.out.print("\nEnter product quantity: ");
            quantity = in.nextLine();
        }

        // If quantity == 0 then print "The item is unavailable due to out of stock."
        // If quantity == 1 then print "The number of item is 1"
        // If quantity => 1 then print "The number of items is " + quantity
        System.out.println(Integer.parseInt(quantity)>1 ? "The number of items is " + Integer.parseInt(quantity) + "." : Integer.parseInt(quantity) <= 0 ? "The item is unavailable due to out of stock." : "The number of item is 1.");
    }
}