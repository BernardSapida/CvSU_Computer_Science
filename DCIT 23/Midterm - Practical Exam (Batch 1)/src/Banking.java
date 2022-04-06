import java.util.regex.Pattern;
import java.util.Scanner;

public class Banking {
    public static Banking bank = new Banking();
    public static Account acc = new Account();
    static Scanner in = new Scanner(System.in);
    public static boolean isSuccess = true;
    public String username, accountNumber, toWithdraw;
    public static int balance = 10_000;

    public static void main(String[] args) throws Exception {
        while(true){
            isSuccess = true;

            // Input for Username
            System.out.print("============================================================================");
            System.out.print("\nUsername: ");
            bank.username = in.nextLine();

            // Validation for Username
            while(!Pattern.compile("^([A-z]|[A-z] [A-z])+$").matcher(bank.username).find()) {
                System.out.println("Invalid username!");
                System.out.print("\nUsername: ");
                bank.username = in.nextLine();
            }

            // Input for Account Number
            System.out.print("Account Number: ");
            bank.accountNumber = in.nextLine();

            // Validation for Account Number
            while(!Pattern.compile("^[0-9]{13}$").matcher(bank.accountNumber).find()) {
                System.out.println("Invalid account number!");
                System.out.print("\nAccount Number: ");
                bank.accountNumber = in.nextLine();
            }

            // Input for Money to withdraw
            System.out.print("Amount to Withdraw: ");
            bank.toWithdraw = in.nextLine();

            // Validation for Money to withdraw
            while(!Pattern.compile("^[0-9]+$").matcher(bank.toWithdraw).find()) {
                System.out.println("Invalid input!");
                System.out.print("\nAmount to Withdraw: ");
                bank.toWithdraw = in.nextLine();
            }

            // Invoke withdraw method and process the data.
            acc.withdrawal(balance, Integer.parseInt(bank.toWithdraw));

            // Printing result
            if(isSuccess) {
                System.out.println("\n--------------Bank Receipt:--------------");
                System.out.println("Username: "+bank.username);
                System.out.println("Account Number: "+bank.accountNumber);
                System.out.println("Amount withdraw: "+bank.toWithdraw);
                System.out.println("Remaining Balance: "+balance);
            }
        }
    }
}