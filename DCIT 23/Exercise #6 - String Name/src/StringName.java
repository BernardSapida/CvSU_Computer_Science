import java.lang.String;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringName {
    private String name;
    private String[] splitName;
    public static void main(String[] args) throws Exception {
        StringName name = new StringName();
        name.getNewNameFormat();
    }

    private void getNewNameFormat() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Name: ");
        name = in.nextLine();

        while(!Pattern.compile("^[A-z]+ [A-z]+$").matcher(name).find()) {
            System.out.println("Your input is invalid!");
            System.out.print("\nEnter Name: ");
            name = in.nextLine();
        }

        this.splitName = name.split(" ");

        System.out.println("Your name is: " + splitName[1] + ", " + name.charAt(0) + ".");
        System.out.println("No. of Char: " + splitName[0].length());
        in.close();
    }
}