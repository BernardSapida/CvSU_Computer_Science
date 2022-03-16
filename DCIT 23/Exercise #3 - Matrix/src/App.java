/* Author: Bernard Sapida */

public class App {
    public static void main(String[] args) throws Exception {
        // Swap the variable value using expression.
        int x = 14, y = 7, z;

        // z = 14 + 7 => 21
        z = x + y;

        // x = 21 - 14 => 7
        x = z - x;

        // y = 21 - 7 => 14
        y = z - y;

        System.out.println("x: " + x + "\n" + "y: " + y);
    }
}
