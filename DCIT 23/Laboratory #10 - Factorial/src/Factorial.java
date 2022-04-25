import java.util.Scanner;
import java.util.regex.Pattern;

public class Factorial {
    public static void main(String[] args) throws Exception {
        // Scanner Class
        Scanner in = new Scanner(System.in);

        // Display Factorial Title
        System.out.println("\n=====================================================");
        System.out.println("||              FINDING THE FACTORIAL              ||");
        System.out.println("=====================================================\n");

        // Prompt the user to enter a number
        System.out.print("Enter Number: ");
        String factorial = in.nextLine();

        // Validating user input if it is a number
        while(!Pattern.compile("^[0-9]+$").matcher(factorial).find()) {
            System.out.println("Your input is invalid!");
            System.out.print("\nEnter Number: ");
            factorial = in.nextLine();
        }

        // getFactorial method will calculate the factorial and print the result in console
        System.out.println(getFactorial(Integer.parseInt(factorial)));;
    }

    public static String getFactorial(int n) {
        String calculation = String.valueOf(n) + "! = ";
        long result = 1;

        if(n == 1) return calculation += n;

        for(; n > 0; n--) {
            if(n != 1) calculation += (n + " x ");
            if(n == 1) calculation += n;
            result *= n;
        }

        calculation += (" = " + result);

        return calculation;
    }
}