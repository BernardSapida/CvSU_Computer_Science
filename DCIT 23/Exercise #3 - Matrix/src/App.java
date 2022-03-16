/* Author: Bernard Sapida */

public class App {
    public static void main(String[] args) throws Exception {
        // Swapping Variable Value
        int x = 14, y = 7, z;

        // x = (14 + 7) - 14 => 7
        x = (x + y) - x;

        // z = 7 + 7 => 14 
        z = x + y;

        // y = 14 => 14
        y = z;

        System.out.println("x: " + x + ", " + "y: " + y);
    }
}
