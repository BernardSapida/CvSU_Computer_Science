import java.lang.String;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringName {
    // StringName Field
    private String name;
    private String[] splitName;
    public static void main(String[] args) throws Exception {
        // Instantiating StringName
        StringName name = new StringName();
        name.getNewNameFormat();
    }

    // getNewNameFormat method return the Surname, Firstname format.
    // Expected sample output (Sapida, B.)
    private void getNewNameFormat() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Name: ");
        name = in.nextLine();

        while(!Pattern.compile("^[A-z]+ [A-z]+$").matcher(name).find()) {
            System.out.println("Your input is invalid!");
            System.out.print("\nEnter Name: ");
            name = in.nextLine();
        }

        // Split the string and transform into array
        // The array has 2 items => ["Firstname", "Lastname"]
        this.splitName = name.split(" ");

        // Printing the result
        System.out.println("Your name is: " + splitName[1] + ", " + name.charAt(0) + ".");
        System.out.println("No. of Char: " + splitName[0].length());
        in.close();
    }
}