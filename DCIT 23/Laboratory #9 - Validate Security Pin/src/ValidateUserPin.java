import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateUserPin {
    // Declare a valid integer pin
    static int validPin = 11318071;

    public static void main(String[] args) throws Exception {
        // Scanner Class
        Scanner in = new Scanner(System.in);

        // Prompt the user to enter the PIN
        System.out.print("Enter Pin: ");
        String userPin = in.nextLine();
    
        // Validate user entered pin (Number String) if it's matched to valid pin.
        // The input should be type of String to avoid error if the user will input text [A-z]+.
        while(!Pattern.compile(String.valueOf(validPin)).matcher(userPin).find()) {
            System.out.println("Your pin is incorrect!");
            System.out.print("\nEnter Pin: ");
            userPin = in.nextLine();
        }

        // Print the message that user has now access to their account
        System.out.println("\n=====================================================");
        System.out.println("||Successfully! You have an access to your account.||");
        System.out.println("=====================================================");

        in.close();
    }
}