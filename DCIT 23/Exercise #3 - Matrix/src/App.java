/* Author: Bernard Sapida */

public class App {
    public static void main(String[] args) throws Exception {
        int x = 4, y = 7, z;
        z = 4; x = y; y = z;
        System.out.println("x: " + x + ", " + "y: " + z);
    }
}
