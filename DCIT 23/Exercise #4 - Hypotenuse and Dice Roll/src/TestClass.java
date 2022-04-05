import java.util.*; // Scanner

public class TestClass {
    // TestClass Fields
    public static int a, b;
    
    
    public static void main(String[] args) throws Exception {
        // Instantiating TextClass Object
        TestClass tc = new TestClass();

        // Instantiating ComputeMethods Object
        ComputeMethods cm = new ComputeMethods();

        // Calling askQuestions method of TestClass
        tc.askQuestions();

        // Result of the Hypotenuse
        System.out.println("Hypotenuse is " + cm.hypotenuse(a, b));

        // Result of the Dice
        System.out.println("The result of the dice is " + cm.roll());
    }

    private void askQuestions() {
        // Instantiating Scanner
        Scanner in = new Scanner(System.in);

        // Header Title
        System.out.println("===========================\n|| HYPOTENUSE CALCULATOR ||\n===========================");

        // User Input for a and b
        System.out.print("Input the value for a: ");
        a = in.nextInt();
        System.out.print("Input the value for b: ");
        b = in.nextInt();

        // Closing the Scanner
        in.close();
    }
}