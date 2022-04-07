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

            System.out.print("\nUsername: ");
            bank.username = in.nextLine();

            System.out.print("Account Number: ");
            bank.accountNumber = in.nextLine();

            System.out.print("Amount to Withdraw: ");
            bank.toWithdraw = in.nextLine();

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