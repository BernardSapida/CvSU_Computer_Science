import java.util.Scanner;
import java.util.regex.Pattern;

public class StringEquality {
    // StringEquality Fields
    public static Scanner in = new Scanner(System.in);
    public static String name;

    public static void main(String[] args) throws Exception {
        // Invoking isKing methods
        while(true) {
            isKing();
        }
    }

    public static void isKing() {
        // Ask for user name.
        System.out.print("\nEnter Name: ");
        name = in.nextLine();

        // Validate user input
        while(!Pattern.compile("^[A-z]+$").matcher(name).find()) {
            System.out.println("Invalid input!");
            System.out.print("\nEnter Name: ");
            name = in.nextLine();
        }

        // If name == Moe or name == moe then print You are the king of rock and roll.
        // else You are not the king.
        System.out.println(name.equals("Moe")||name.equals("moe") ? "You are the king of rock and roll": "You are not the king.");
    }
}